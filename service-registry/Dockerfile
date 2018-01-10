FROM java:8
COPY ./NextGenServicesRegistry-0.0.1-SNAPSHOT.jar /var/tmp/app.jar
EXPOSE 8088
CMD ["java", "-Xmx256m", "-jar","/var/tmp/app.jar"]