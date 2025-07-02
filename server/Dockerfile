FROM gradle:8.13-jdk17-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew bootJar

FROM eclipse-temurin:17-alpine
EXPOSE ${SERVER_PORT}
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT [ "java", "-jar","app.jar" ]
