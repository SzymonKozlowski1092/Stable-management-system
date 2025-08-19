
# Stable management system

## Overview
A REST API implemented as the backend for an application that simplifies stable management. It enables staff to communicate easily with each other and with boarders, provides a straightforward way to register horses, and offers a secure method for adding new users to the system. All endpoints are secured with JWT based authentication and role aware authorization.

## Technology
- Java 21
- Spring Boot 3 (Web, Security, Data JPA, Validation)
- Microsoft SQL Server
- JWT (jjwt)
- MapStruct
- Maven

## Prerequisites
- JDK 21 installed
- Maven 3.5+ or the bundled `mvnw` wrapper
- Access to a Microsoft SQL Server instance

## Configuration
1. Create `stable-management-api/src/main/resources/application-local.properties`.
2. Set database properties (`spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`).
3. Configure any additional Spring or JWT settings as required.

## Build
```bash
cd stable-management-api
mvn package
```

## Run
```bash
mvn spring-boot:run
```
or after building:
```bash
java -jar target/stable-management-api-0.0.1-SNAPSHOT.jar
```

## Features
The project includes controllers for:
- user authentication,
- horse and owner management,
- registration codes,
- notes,
- user data management.

## Example Endpoints
- `POST /api/auth/register` – create a new account
- `POST /api/auth/login` – obtain a JWT token
- `GET /api/horses` – list all horses (manager/employee)
- `POST /api/registration-code/generate?role=MANAGER` – generate registration code

## Author
- [@SzymonKozlowski1092](https://www.github.com/SzymonKozlowski1092)
