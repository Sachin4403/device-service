FROM adoptopenjdk/openjdk11:latest
RUN mkdir /opt/app
COPY src/main/resources/file03.txt /opt/app
COPY target/device-service-1.0-SNAPSHOT.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/device-service-1.0-SNAPSHOT.jar"]
