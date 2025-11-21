FROM eclipse-temurin:21-jdk-jammy AS build
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

FROM eclipse-temurin:21-jre-jammy
COPY --from=build /build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
