# Microservices Template #
The aim of this repository is to provide a quick start for the development of microservices. We try to keep the template as simple as posible. We´ll continue adding functionality and releasing new versions. 

For an intro to Microservices architecture, please take a look at these slides:
http://www.simtlix.com/en/tech-talk-about-microservices-by-florencia-bonansea/

## Getting Started ##
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes

### Install Docker ###
* Download and install Docker: https://docs.docker.com/install/
* Verify docker installation: docker version
* Verify docker-compose installation: docker-compose version

### Build and run Docker containers ###
* Windows: ./start.bat
* Unix: ./start.sh

### Verify environment is working ###
http://localhost:8080/greetings

### Clear the environment ###
Once you finished playing around and you want to clear allocated resources (such as space, memory and ports), you have to execute:
```bash
docker-compose -f docker/docker-compose.yml down
```

### Known issues with Windows Docker volumes ###
* Go to Docker preferences and grant permissions on the local storage.
* Review https://forums.docker.com/t/trying-to-get-postgres-to-work-on-persistent-windows-mount-two-issues/12456/5

## Technologies ##
* Spring Boot
* Docker
* MongoDB
* PostreSQL

## Examples ##
### MongoDB CRUD ###
```bash 
curl -X GET \
  http://localhost:8080/api/users/1 \
  -H 'Accept: application/json' 
 ``` 

```bash
curl -X POST \
  http://localhost:8080/api/users \
  -H 'Content-Type: application/json' \
  -d '{
	"firstName":"test",
	"lastName":"test",
	"email":"test"
}'
```

### PostgresDB CRUD ###
```bash 
curl -X GET \
  http://localhost:8080/api/customers \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
 ``` 

```bash
curl -X POST \
  http://localhost:8080/api/customers \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
        "name": "Jose",
        "lastName": "Perez",
        "email": "joseperez@gmail.com"
    }'
```

## Authors ##
Microservices Technology Group @ Simtlix
http://www.simtlix.com/en/technology-groups
