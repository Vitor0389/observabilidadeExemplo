# Etapa 1: Build com Maven e Java 17
FROM maven:3.9.8-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Runtime com OpenTelemetry Java Agent
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia o JAR da etapa anterior
COPY --from=builder /app/target/*.jar app.jar


COPY opentelemetry-javaagent.jar .
EXPOSE 8080

# Usa o agente automaticamente
ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "app.jar"]
