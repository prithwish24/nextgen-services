FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-monitor.jar /var/apps/nextgen-monitor.jar
EXPOSE 9080
CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-monitor.jar"]