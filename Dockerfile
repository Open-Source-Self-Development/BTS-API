# Geliştirme aşaması - Development Stage
FROM maven:3-openjdk-17-slim AS development
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=dev"]

# Build aşaması - Build Stage
FROM maven:3-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Üretim aşaması - Production Stage
FROM openjdk:17-jdk-slim AS production
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]