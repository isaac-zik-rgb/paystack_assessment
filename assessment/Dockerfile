FROM openjdk:17-jdk-slim
LABEL authors="Chima"

# Set the working directory in the container
WORKDIR /assessment
# Copy the JAR file from the target directory into the container

COPY build/libs/assessment-0.0.1-SNAPSHOT.jar assessment.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","assessment.jar"]