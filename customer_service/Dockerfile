FROM openjdk:13-jdk-alpine
EXPOSE 9010
COPY target/customer_service-1.0-SNAPSHOT.jar /customer_service-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/customer_service-1.0-SNAPSHOT.jar"]