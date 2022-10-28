FROM openjdk:11-jdk-oracle
COPY ./target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]