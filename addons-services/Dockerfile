FROM java:8
COPY ./NextGenAddOnServices-0.0.1-SNAPSHOT.jar /var/tmp/app.jar
EXPOSE 8003
CMD ["java", "-Xmx256m", "-jar","/var/tmp/app.jar"]