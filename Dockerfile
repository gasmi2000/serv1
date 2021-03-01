# For Java 8, try this
FROM openjdk:8-jdk-alpine

# For Java 11, try this
# FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/ttn-api-commercial.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/ttn-api-commercial.jar /opt/app/ttn-api-commercial.jar
COPY ${JAR_FILE} ttn-api-commercial.jar

EXPOSE 8180
# java -jar /opt/app/ttn-api-commercial.jar
ENTRYPOINT ["java","-jar","ttn-api-commercial.jar"]