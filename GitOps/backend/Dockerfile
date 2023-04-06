FROM bellsoft/liberica-openjdk-alpine:17.0.6-10
RUN mkdir /opt/app
COPY target/*.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]
