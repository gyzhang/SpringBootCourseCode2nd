FROM bellsoft/liberica-openjdk-alpine:17.0.6-10
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
