FROM openjdk:13-jdk-alpine
EXPOSE 9040
ADD target/streaming_service-1.0-SNAPSHOT.jar streaming_service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/streaming_service-1.0-SNAPSHOT.jar"]