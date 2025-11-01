FROM nginx:alpine
RUN apk update && apk add openjdk21-jre-headless
COPY build/libs/Application-*-SNAPSHOT.jar app.jar
COPY /frontend /usr/share/nginx/html
EXPOSE 9090
EXPOSE 80
CMD ["java", "-jar", "app.jar"]