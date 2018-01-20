FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
RUN apk add --no-cache netcat-openbsd
COPY wait-for-config.sh  /var/apps/wait-for-config.sh
RUN chmod 755 /var/apps/wait-for-config.sh
COPY target/nextgen-addon-svcs.jar /var/apps/nextgen-addon-svcs.jar
EXPOSE 8003
ENTRYPOINT ["/var/apps/wait-for-config.sh"]
#CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-addon-svcs.jar"]
