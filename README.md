# Book Track and Stock API

This project is a Spring Boot application for book tracking and stock management, using PostgreSQL as the database.

## Prerequisites

- Docker
- Docker Compose
- Java 17
- Maven


## Project Structure

- `Dockerfile`: Multi-stage Dockerfile for both development and production environments
- `docker-compose.dev.yml`: Docker Compose file for the development environment
- `docker-compose.prod.yml`: Docker Compose file for the production environment

## Development Environment

### docker-compose.dev.yml

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:16-alpine
    ports:
      - "5432:5432"
    volumes:
      - ~/apps/postgres:/var/lib/postgresql/data
    environment:
      - POSTGRES_PASSWORD=iDADK8jlqDc0yi9U3v19z
      - POSTGRES_USER=stock_sql_user
      - POSTGRES_DB=stock_db
    networks:
      - spring-postgres

  spring-app-dev:
    build:
      context: .
      dockerfile: Dockerfile
      target: development
    ports:
      - "8080:8080"
    depends_on:
      - postgres
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/stock_db
      - SPRING_DATASOURCE_USERNAME=stock_sql_user
      - SPRING_DATASOURCE_PASSWORD=iDADK8jlqDc0yi9U3v19z
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
    volumes:
      - ./:/app
      - ~/.m2:/root/.m2
    networks:
      - spring-postgres

networks:
  spring-postgres:
```

## Running the Development Environment
To start the development environment, run:
```yaml
docker-compose -f docker-compose.dev.yml up --build
```

This command will build the Docker images and start the containers for the development environment.

To stop the development environment, use:
```yaml
docker-compose -f docker-compose.dev.yml down
```
Alternatively, after building the project, you can use:
```yaml
docker-compose up postgres spring-app-dev
```


## Manually Starting the Development Environment
To manually start the development environment:

- Ensure PostgreSQL is running and configured with the correct credentials.
- Navigate to the project root directory.
- Run the following command:

```yaml
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```


## Production Environment
### docker-compose.prod.yml
```yaml


version: '3.8'

services:
  postgres:
    image: postgres:16-alpine
    ports:
      - "5432:5432"
    volumes:
      - ~/apps/postgres:/var/lib/postgresql/data
    environment:
      - POSTGRES_PASSWORD=iDADK8jlqDc0yi9U3v19z
      - POSTGRES_USER=stock_sql_user
      - POSTGRES_DB=stock_db
    networks:
      - spring-postgres

  spring-app-prod:
    build:
      context: .
      dockerfile: Dockerfile
      target: production
    ports:
      - "8081:8080"
    depends_on:
      - postgres
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/stock_db
      - SPRING_DATASOURCE_USERNAME=stock_sql_user
      - SPRING_DATASOURCE_PASSWORD=iDADK8jlqDc0yi9U3v19z
      - SPRING_JPA_HIBERNATE_DDL_AUTO=update
    networks:
      - spring-postgres

networks:
  spring-postgres:
```
## Running the Production Environment
To start the production environment, run:
```yaml
docker-compose -f docker-compose.prod.yml up --build
```

This command will build the Docker images and start the containers for the production environment.

To stop the production environment, use:
```yaml
docker-compose -f docker-compose.prod.yml down
```
Alternatively, after building the project, you can use:
```yaml
docker-compose up postgres spring-app-prod
```
## Manually Starting the Production Environment
To manually start the production environment:

- Ensure PostgreSQL is running and configured with the correct credentials.
- Navigate to the project root directory.
- Build the application:
```yaml
mvn clean package -DskipTests
```
- Run the application:
```yaml
java -jar target/your-application-name.jar
```
Replace your-application-name.jar with the actual name of your built JAR file.

```yaml
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```
## Running Both Environments Together
To run both development and production environments simultaneously:

```yaml
docker-compose up --build
```

## Dockerfile
```yaml
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
```

## Accessing the Application
- Development: The application will be available at http://localhost:8080
- Production: The application will be available at  http://localhost:8081

## Database
PostgreSQL database will be accessible at:

- Host: localhost
- Port: 5432
- Database: stock_db
- Username: stock_sql_user
- Password: iDADK8jlqDc0yi9U3v19z

## Notes

- The development environment uses volume mounts to enable hot-reloading of the application.
- The production environment builds the application and runs it in a separate container.
- Make sure to secure your database credentials and other sensitive information before deploying to a public environment.
- You can modify the database information as needed or replace it with your own remote server details when deploying the application to production. For example, you might want to use a managed database service or a separate database server in your production environment.


