FROM openjdk:8-jdk-alpine
COPY ./target/SampleDockerApp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80
CMD ["java","-jar","app.jar"]