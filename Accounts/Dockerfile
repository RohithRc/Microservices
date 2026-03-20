# Use lightweight Java 21 runtime
FROM eclipse-temurin:21-jdk

# Metadata (optional but good practice)
LABEL org.opencontainers.image.authors="rohith"

# Copy jar from target folder into container
COPY target/Accounts-0.0.1-SNAPSHOT.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "/app.jar"]