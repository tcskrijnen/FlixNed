FROM openjdk:13-jdk-alpine
EXPOSE 9030
ADD target/content_service-1.0-SNAPSHOT.jar content_service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/content_service-1.0-SNAPSHOT.jar"]