FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-config.jar /var/apps/
CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-config.jar"]
EXPOSE 8199