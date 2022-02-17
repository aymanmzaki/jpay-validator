FROM openjdk:11

MAINTAINER AymanZaki

ARG JAR_FILE=target/[artifactId]*SNAPSHOT.jar

COPY ${JAR_FILE} app.jar
COPY sample.db sample.db

ENTRYPOINT ["java","-jar","/app.jar"]
