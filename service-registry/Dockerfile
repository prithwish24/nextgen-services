FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-registry.jar /var/apps/
COPY wait-for-config.sh  /var/apps/
RUN chmod 755 /var/apps/wait-for-config.sh
RUN apk add --no-cache netcat-openbsd
EXPOSE 8088
ENTRYPOINT ["/var/apps/wait-for-config.sh"]
#CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-registry.jar"]
