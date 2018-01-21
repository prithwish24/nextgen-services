FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
RUN apk add --no-cache netcat-openbsd
COPY wait-for-config.sh  /var/apps/
RUN chmod 755 /var/apps/wait-for-config.sh
COPY target/nextgen-reservation.jar /var/apps/
EXPOSE 8002
ENTRYPOINT ["/var/apps/wait-for-config.sh"]
#CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-reservation.jar"]
