FROM java:8
COPY ./NextGenMonitoring-0.0.1-SNAPSHOT.jar /var/tmp/app.jar
EXPOSE 9080
CMD ["java", "-Xmx256m", "-jar","/var/tmp/app.jar"]