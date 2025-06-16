FROM openjdk:23-jdk AS builder
WORKDIR /build-app
COPY . .
RUN microdnf install findutils dos2unix && \
    dos2unix ./gradlew && \
    chmod +x ./gradlew && \
   ./gradlew clean build -x test --no-daemon

FROM openjdk:23-jdk AS runner
WORKDIR /app
COPY --from=builder /build-app/build/libs/users.jar /app/users.jar
ENTRYPOINT ["java", "-jar", "users.jar", "--spring.config.additional-location=/app/application.properties"]
