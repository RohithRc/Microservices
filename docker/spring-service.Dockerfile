# Build args: JAR_FILE = path relative to repo root, e.g. Accounts/target/Accounts-0.0.1-SNAPSHOT.jar
# Prerequisite: run ./mvnw -DskipTests package in that module first.
FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl

ARG JAR_FILE
COPY ${JAR_FILE} /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
