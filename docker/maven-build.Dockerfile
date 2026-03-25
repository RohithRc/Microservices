# Multi-stage: Maven build inside Docker (no local target/*.jar required).
# Use with build.context = that service’s folder (e.g. ./config-server).
#
# Picks the runnable JAR from target/ (excludes *-plain, *-sources, *-javadoc).

FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY . .

# Use image Maven (not mvnw): Cards/loans omit .mvn/wrapper; wrapper is optional here.
RUN mvn -B -DskipTests package

RUN mkdir /staging && \
    MAIN_JAR="$(find target -maxdepth 1 -type f -name '*.jar' \
      ! -name '*-plain.jar' ! -name '*-sources.jar' ! -name '*-javadoc.jar' | head -n 1)" && \
    test -n "$MAIN_JAR" && cp "$MAIN_JAR" /staging/app.jar

FROM eclipse-temurin:21-jre-alpine
RUN apk add --no-cache curl
COPY --from=build /staging/app.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
