FROM openjdk:13-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG BUILD_DIR=build
COPY ${BUILD_DIR}/libs /app/lib/
ENTRYPOINT ["java","-jar","app/lib/gs-spring-boot-docker-0.1.0.jar"]