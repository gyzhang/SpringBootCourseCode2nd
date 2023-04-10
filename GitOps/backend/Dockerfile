FROM bellsoft/liberica-openjdk-alpine:17.0.6-10
RUN echo "https://mirrors.aliyun.com/alpine/v3.6/main/" > /etc/apk/repositories
RUN echo "https://mirrors.aliyun.com/alpine/v3.6/community/" >> /etc/apk/repositories
RUN ["apk","update"]
RUN ["apk","add","curl"]
RUN mkdir /opt/app
COPY target/*.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]
