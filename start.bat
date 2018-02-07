docker build -f docker/maven/Dockerfile -t maven:custom .

docker run --rm -v %USERPROFILE%/.m2:/root/.m2 -v %cd%\template:/template -w /template maven:custom mvn clean install

docker build -f docker/template/Dockerfile -t template .

docker-compose -f docker/docker-compose.yml up -d