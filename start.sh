#!/bin/bash

WORKDIR="`dirname \"$0\"`"              # relative
WORKDIR="`( cd \"$WORKDIR\" && pwd )`"  # absolutized and normalized

# create local volumes
docker volume create -d local --name postgres-volume
docker volume create -d local --name mongodb-volume

# prepare build images
docker build -f docker/maven/Dockerfile -t maven:custom .

# maven build
docker run --rm -ti --name maven-build -v ~/.m2:/root/.m2 -v $(pwd)/template:/template -w /template maven:custom mvn clean install

# template image build
docker build -f docker/template/Dockerfile -t template .

# run compose file
docker-compose -f docker/docker-compose.yml up -d