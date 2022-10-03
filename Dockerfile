FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/back-end-L_1.jar back-end-L_1.jar
ENTRYPOINT ["java", "-jar", "/back-end-L_1.jar"]