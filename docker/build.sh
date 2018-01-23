#!/bin/bash

WORKDIR="`dirname \"$0\"`"              # relative
WORKDIR="`( cd \"$MY_PATH\" && pwd )`"  # absolutized and normalized

docker build -f docker/maven/Dockerfile -t maven:custom .
docker run -ti --rm -v ~/.m2:/root/.m2 -v $WORKDIR/template:/template -w /template maven:custom mvn clean install

docker build -f docker/template/Dockerfile -t template .