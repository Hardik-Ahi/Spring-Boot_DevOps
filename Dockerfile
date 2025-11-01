FROM alpine:latest
RUN apk update && apk add openjdk21-jre-headless
COPY build/libs/Application-*-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]