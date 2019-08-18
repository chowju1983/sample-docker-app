FROM openjdk:8-jdk-alpine
FROM maven:alpine
WORKDIR /usr/app
COPY . /usr/app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 80
CMD ["java","-jar","/root/.m2/repository/com/example/SampleDockerApp/0.0.1-SNAPSHOT/SampleDockerApp-0.0.1-SNAPSHOT.jar"]