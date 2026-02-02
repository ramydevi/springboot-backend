# Use lightweight Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar file into the container
COPY target/shoppinglist-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot port
EXPOSE 8001

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
