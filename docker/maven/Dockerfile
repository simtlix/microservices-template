FROM maven:3.5.2-jdk-9

# workaround for https://github.com/docker-library/openjdk/issues/145
# "cacerts" file taken from openjdk:8-jdk under path /etc/ssl/certs/java/cacerts
COPY docker/maven/cacerts /etc/ssl/certs/java/cacerts