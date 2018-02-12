# Microservices Template #
The aim of this repository is to provide a quick start for the development of microservices. We try to keep the template as simple as posible. This is a live template. We´ll keep adding functionality and release new versions. 

## Getting Started ##
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Install Docker ###
* Download and install Docker: https://docs.docker.com/install/
* Verify docker installation: docker version
* Verify docker-compose installation: docker-compose version

## Build Docker containers ##
./docker/build.sh

## Execute the environment ##
docker-compose -f docker/docker-compose.yml up -d

## Verify environment is working ##
http://localhost:8080/greetings

## Known issues with Windows Docker volumes ##
* Go to Docker preferences and grant permissions on the local storage.
* Review https://forums.docker.com/t/trying-to-get-postgres-to-work-on-persistent-windows-mount-two-issues/12456/5
