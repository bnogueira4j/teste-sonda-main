FROM openjdk:17-slim-buster

WORKDIR /app

RUN mvn -v
RUN mvn clean install -DskipTests
COPY target/sonda.candidato-*.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]