FROM openjdk:13-jdk-alpine
EXPOSE 9020
COPY target/auth-1.0-SNAPSHOT.jar /auth-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/auth-1.0-SNAPSHOT.jar"]