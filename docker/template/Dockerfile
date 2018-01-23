FROM openjdk:9-jdk

COPY template/target/gs-spring-boot-1.0.0-SNAPSHOT.jar /spring-boot.jar
RUN chmod 755 /spring-boot.jar

CMD ["java", "-jar", "/spring-boot.jar"]