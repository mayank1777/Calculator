#This Dockerfile is used to create a Docker image that runs a Java application.
#this docker image will
#Uses OpenJDK 21 to run a Java application.
#Copies the compiled JAR file into the container.
#Sets the working directory.
#Runs the Main class from the JAR file when the container starts.
FROM openjdk:21
COPY ./target/Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java","-cp","Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar","org.example.Main"]
