FROM eclipse-temurin:21-jre

WORKDIR /app

COPY /target/studentManagement-0.0.1-SNAPSHOT.jar app.jar
# Copying local files to work directory and rename it to app.jar | consistency purposes

ENTRYPOINT [ "java", "-jar", "app.jar" ]
# Usually better to use entrypoint because we cant override method like in cmd, unless we want to allow that

# .\mvnw.cmd clean package -DskipTests  ## To get jar files
# docker build -t  student_management_app . ## -t stands for tag, you must be in directory where jar file is
# docker run -p 8081:8081 student_management_app ## -p is for port mapping, we map outside port of container to inside port of our app, second port must match

