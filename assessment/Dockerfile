# Stage 1: Build the JAR
FROM gradle:8.4.1-jdk17 AS build
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Copy the source code
COPY src ./src

# Build the application
RUN ./gradlew clean bootJar --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim
LABEL authors="Chima"

# Set the working directory in the container
WORKDIR /paystack

# Copy the JAR file from the build stage
COPY --from=build /assessment/build/libs/assessment-0.0.1-SNAPSHOT.jar paystack.jar

# Expose the port used by the application
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "paystack.jar"]
