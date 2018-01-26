# How do I get set up? #
NOTE: Example command line orders are relative to the root of the project.

## Install Docker ##
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
* If issue remains, create an external volume and use it explicitely by:
1. Create local volume: docker volume create --name postgres-volume -d local
  1. For more information: https://forums.docker.com/t/trying-to-get-postgres-to-work-on-persistent-windows-mount-two-issues/12456/5
2. docker-compose -f doker/docker-compose-local-volumes.yml up -d