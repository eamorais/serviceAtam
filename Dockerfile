# Utiliza la imagen oficial de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR de tu proyecto a la imagen
COPY target/token-service-1.jar app.jar
COPY books.json books.json

# Expón el puerto 8081
EXPOSE 8081

# Comando para ejecutar la aplicación Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]