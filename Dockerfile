FROM openjdk:8-jre-alpine
COPY ./build/libs/helloSimple-1.0-SNAPSHOT.jar /data/

WORKDIR /data

EXPOSE 8080
ENTRYPOINT java -jar helloSimple-1.0-SNAPSHOT.jar