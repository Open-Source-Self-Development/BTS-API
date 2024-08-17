# Geliştirme aşaması - Development Stage
FROM maven:3-openjdk-17-slim AS development
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY . .
CMD ["mvn", "spring-boot:run", "-Dspring-boot.run.profiles=dev"]