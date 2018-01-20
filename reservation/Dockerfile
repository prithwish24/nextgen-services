FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-reservation.jar /var/apps/nextgen-reservation.jar
EXPOSE 8002
CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-reservation.jar"]