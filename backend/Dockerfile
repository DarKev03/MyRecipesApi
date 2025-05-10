# Usa imagen oficial de Java
FROM eclipse-temurin:17-jdk-alpine

# Crea el directorio de la app
WORKDIR /app

# Copia el jar generado (ajusta el nombre si es distinto)
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto de Spring Boot
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
