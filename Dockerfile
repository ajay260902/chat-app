# Build stage
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app

# Install dependencies only (skips copying files explicitly)
RUN mvn dependency:go-offline

# Build the application directly in the container
CMD ["mvn", "clean", "package", "-DskipTests"]

# Runtime stage
FROM openjdk:11-jre-slim
WORKDIR /app

# Expose the port
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "target/chat-app-backend-0.0.1-SNAPSHOT.jar"]
