FROM openjdk:13-jdk-alpine
WORKDIR /tmp
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ENTRYPOINT ["java","-jar","/service_registration-1.0-SNAPSHOT.jar"]