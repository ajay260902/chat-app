# Build stage
FROM maven:3.8.5-openjdk-17 AS build  # Use OpenJDK 17 for building
WORKDIR /app
COPY pom.xml ./  
COPY src ./src  
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:17-jre-slim  # Use OpenJDK 17 for runtime as well
WORKDIR /app
COPY --from=build /app/target/chat-app-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
