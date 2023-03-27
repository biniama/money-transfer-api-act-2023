FROM maven:latest AS maven
LABEL MAINTAINER="ACT"

# Create a folder called 'app' and move to that folder
WORKDIR /app
# Copy everything in this directory to 'app'
COPY . /app
# Compile and package the application to an executable JAR
RUN mvn package

FROM eclipse-temurin:latest
ARG JAR_FILE=money-transfer-api.jar
WORKDIR /app
COPY --from=maven /target/${JAR_FILE} .

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "money-transfer-api.jar"]
EXPOSE 8080

