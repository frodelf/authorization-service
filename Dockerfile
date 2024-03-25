FROM openjdk:17.0.2-jdk-slim-buster
COPY build/libs/authorization-service.jar authorization-service.jar
ENTRYPOINT ["java", "-jar", "authorization-service.jar"]