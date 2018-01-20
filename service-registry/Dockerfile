FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
COPY target/nextgen-registry.jar /var/apps/nextgen-registry.jar
#RUN apk add --no-cache bash
RUN apk add --no-cache netcat-openbsd
COPY wait-for-config.sh  /var/apps/wait-for-config.sh
RUN chmod 755 /var/apps/wait-for-config.sh
EXPOSE 8088
ENTRYPOINT ["/var/apps/wait-for-config.sh"]
#CMD ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-registry.jar"]
