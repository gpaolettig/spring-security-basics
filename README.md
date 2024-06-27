# API de Autenticación y Registro de Usuarios  
[![Java](https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white)](https://www.java.com/) 
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)

API RESTful permite crear usuarios e iniciar sesión.
## Instalación
### Construir la imagen docker
```bash
docker build -t spring-security-basics .
```
### Ejecuta el contenedor
```bash
docker run -p 8080:8080 spring-security-basics
```
## Endpoints
### Registrar usuario
```http
POST localhost:8080/auth/register
```
- URL: localhost:8080/auth/register
- Método: POST
- Respuesta: 201 Created
 
Body:
 ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "password": "password123"
    }
 ```
### Iniciar sesion
```http
POST localhost:8080/auth/login
```
- URL: localhost:8080/auth/login
- Método: POST
- Respuesta: 202 Accepted - JWT
 
Body:
 ```json
    {
      "email": "john.doe@example.com",
      "password": "password123"
    }
 ```


