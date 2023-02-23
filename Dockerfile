# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the packaged jar file into the container at /app
COPY target/soberail-0.0.1-SNAPSHOT.jar /app

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the jar file when the container starts
CMD ["java", "-jar", "soberail-0.0.1-SNAPSHOT.jar"]
