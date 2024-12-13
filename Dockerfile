# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Install dependencies only (skips copying files explicitly)
RUN mvn dependency:go-offline

# Build the application directly in the container
CMD ["mvn", "clean", "package", "-DskipTests"]

# Runtime stage
FROM openjdk:17-jre-slim
WORKDIR /app

# Expose the port
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "target/*.jar"]
