FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-addon-svcs.jar /var/apps/nextgen-addon-svcs.jar
EXPOSE 8003
CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-addon-svcs.jar"]