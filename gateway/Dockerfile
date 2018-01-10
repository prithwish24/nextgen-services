FROM java:8
COPY ./NextGenServicesGateway-0.0.1-SNAPSHOT.jar /var/tmp/app.jar
EXPOSE 8080
CMD ["java", "-Xmx256m", "-jar","/var/tmp/app.jar"]