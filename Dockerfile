FROM adoptopenjdk/openjdk11

COPY sample.db sample.db
COPY target/jpay-validator-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
