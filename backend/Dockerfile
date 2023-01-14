FROM openjdk:17
EXPOSE 8080
ADD target/studenture-backend.jar studenture-backend.jar
ENTRYPOINT ["java","-jar", ""]
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/studenture-backend.jar"]