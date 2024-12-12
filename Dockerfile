# Build stage
FROM maven:3.8.5-openjdk-11 AS build
WORKDIR /app

# Copy pom.xml and dependencies first (to leverage Docker caching)
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the source code
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:11-jre-slim
WORKDIR /app

# Copy the generated JAR file
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
