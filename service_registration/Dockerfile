FROM openjdk:13-jdk-alpine
EXPOSE 8761
ADD target/service_registration-1.0-SNAPSHOT.jar service_registration-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/service_registration-1.0-SNAPSHOT.jar"]