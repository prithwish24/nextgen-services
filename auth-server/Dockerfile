FROM openjdk:8-jre-alpine
LABEL maintainer1="Prithwish Ghosh"
LABEL maintainer2="Tanmoy Biswas"
ADD target/nextgen-auth.jar /var/apps/nextgen-auth.jar
ENTRYPOINT ["java", "-Xmx256m", "-jar", "/var/apps/nextgen-auth.jar"]
EXPOSE 8079