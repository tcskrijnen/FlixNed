FROM openjdk:13-jdk-alpine
EXPOSE 8762
ADD target/gateway-1.0-SNAPSHOT.jar gateway-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gateway-1.0-SNAPSHOT.jar"]