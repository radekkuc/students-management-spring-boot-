FROM eclipse-temurin:21-jre
# Base image

WORKDIR /app
# Working directory in container

COPY /target/studentManagement-0.0.1-SNAPSHOT.jar app.jar
# Copying local files to this thing, but dont really understand

ENTRYPOINT [ "java", "-jar", "app.jar" ]
# why entrypoint instead of cmd / Running app



## .\mvnw.cmd clean package -DskipTests

