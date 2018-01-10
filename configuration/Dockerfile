FROM java:8
COPY ./NextGenConfiguration-0.0.1-SNAPSHOT.jar /var/tmp/app.jar
EXPOSE 8199
CMD ["java", "-Xmx256m", "-jar","/var/tmp/app.jar"]