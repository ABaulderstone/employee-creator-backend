FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn package -DskipTests

# Second stage: Run the Spring application
FROM eclipse-temurin:17

WORKDIR /app
EXPOSE 8080

COPY --from=builder /app/target/employee-creator-backend.jar .

CMD ["java", "-jar", "employee-creator-backend.jar"]