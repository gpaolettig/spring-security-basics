FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY ./target/spring-security-basics-0.0.1-SNAPSHOT.jar spring-security-basics.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-security-basics.jar"]
