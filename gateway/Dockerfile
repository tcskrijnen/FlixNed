FROM openjdk:13-jdk-alpine
VOLUME /tmp
COPY target/gateway-1.0-SNAPSHOT.jar /home/gateway-1.0-SNAPSHOT.jar
CMD ["java","-jar","/home/gateway-1.0-SNAPSHOT.jar"]