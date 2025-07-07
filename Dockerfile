# Use official Maven image to build the app
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use lightweight JDK base image for running the app
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy jar from the build stage
COPY --from=build /app/target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (optional)
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
