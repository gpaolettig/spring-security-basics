# User Registration and Authentication AP
[![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)](https://www.java.com/) 
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-5.8.0-brightgreen?logo=spring&logoColor=white)](https://spring.io/projects/spring-security)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.2.5-brightgreen?logo=spring&logoColor=white)](https://spring.io/projects/spring-data-jpa)
[![JWT](https://img.shields.io/badge/JWT-JSON%20Web%20Tokens-blue?logo=json-web-tokens&logoColor=white)](https://jwt.io/)
[![OpenSSL](https://img.shields.io/badge/OpenSSL-1.1.1-blue?logo=openssl&logoColor=white)](https://www.openssl.org/)
[![H2 Database](https://img.shields.io/badge/H2-Database-blue?logo=h2&logoColor=white)](https://www.h2database.com/)
## Installation
### Build the docker image
```bash
docker build -t spring-security-basics .
```
### Running the container
```bash
docker run -p 8080:8080 spring-security-basics
```
## Endpoints
### Register user
```http
POST localhost:8080/auth/register
```
- URL: localhost:8080/auth/register
- Method: POST
- Response: 201 Created
 
Body:
 ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "password": "password123"
    }
 ```
### Login
```http
POST localhost:8080/auth/login
```
- URL: localhost:8080/auth/login
- Method: POST
- Response: 202 Accepted - JWT
 
Body:
 ```json
    {
      "email": "john.doe@example.com",
      "password": "password123"
    }
 ```


