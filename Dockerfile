FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN chmod +x gradlew
RUN ./gradlew dependencies --no-daemon

COPY src src

RUN ./gradlew bootJar -x test --no-daemon

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/examen1-0.0.1-SNAPSHOT.jar"]