FROM eclipse-temurin:17-jre-alpine
COPY target/*.jar strings.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/strings.jar"]
