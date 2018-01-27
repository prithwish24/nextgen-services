FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-gateway.jar /var/apps/
CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-gateway.jar"]
EXPOSE 8080
