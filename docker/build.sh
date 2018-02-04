#!/bin/bash

WORKDIR="`dirname \"$0\"`"              # relative
WORKDIR="`( cd \"$WORKDIR\" && pwd )`"  # absolutized and normalized

# create local volumes
docker volume create -d local --name maven-cache
docker volume create -d local --name workspace
docker volume create -d local --name postgres-volume
docker volume create -d local --name mongodb-volume

# prepare build images
docker build -f docker/maven/Dockerfile -t maven:custom .

# maven build
docker rm maven-build
docker create --name maven-build -v maven-cache:/root/.m2 -v workspace:/template -w /template maven:custom mvn clean install
docker cp $WORKDIR/template maven-build:/
docker start -a maven-build
docker cp maven-build:/template/target $WORKDIR/template/target
docker rm maven-build

# template image build
docker build -f docker/template/Dockerfile -t template .