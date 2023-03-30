FROM maven:3.9.0-eclipse-temurin-8-alpine as maven
LABEL MAINTAINER="ACT"

WORKDIR /usr/src/app
COPY . /usr/src/app
# Compile and package the application to an executable JAR
RUN mvn package

FROM eclipse-temurin:latest
ARG JAR_FILE=money-transfer-api.jar
WORKDIR /opt/app
# Copy the money-transfer-api.jar from the maven stage to the /opt/app directory of the current stage.
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/

ENTRYPOINT ["java","-jar","money-transfer-api.jar"]
EXPOSE 8080

