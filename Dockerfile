FROM openjdk:8-jdk-alpine
FROM maven:alpine
WORKDIR /usr/app
COPY . /usr/app
RUN mvn -v
RUN mvn clean install -DskipTests
COPY ./target/SampleDockerApp-0.0.1-SNAPSHOT.jar /usr/app/
EXPOSE 80
CMD ["java","-jar","SampleDockerApp-0.0.1-SNAPSHOT.jar"]