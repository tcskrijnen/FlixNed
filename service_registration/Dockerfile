FROM openjdk:13-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "service_registration-1.0.SNAPSHOT.jar"]