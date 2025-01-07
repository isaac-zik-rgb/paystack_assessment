# Stage 1: Build the JAR
FROM gradle:8.3.0-jdk17 AS build
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src ./src

# Build the application
RUN ./gradlew clean build

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim
LABEL authors="Chima"

# Set the working directory in the container
WORKDIR /assessment

# Copy the JAR file from the build stage into the container
COPY --from=build /app/build/libs/assessment-0.0.1-SNAPSHOT.jar assessment.jar

# Expose the port used by the application
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "assessment.jar"]
