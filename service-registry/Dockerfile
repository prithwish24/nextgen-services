FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-registry.jar /var/apps/
CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-registry.jar"]
EXPOSE 8088