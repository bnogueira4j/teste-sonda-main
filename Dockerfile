# Build stage
FROM maven:3.8.3-openjdk-17-slim AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests


# Package stage
FROM openjdk:17-slim-buster

WORKDIR /app/target

COPY --from=build /app/target/sonda.candidato-*.jar /app/target/sonda.jar

ENTRYPOINT ["java","-jar","/app/target/sonda.jar"]