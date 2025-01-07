FROM openjdk:17-jdk-slim
LABEL authors="Chima"

# Set the working directory in the container
WORKDIR /paystack
# Copy the JAR file from the target directory into the container
COPY --from=build /libs/assessment-0.0.1-SNAPSHOT.jar paystack.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","paystack.jar"]