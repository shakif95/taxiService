FROM adoptopenjdk/openjdk11:alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar
EXPOSE 8080

ENTRYPOINT java -Dnashorn.args=--no-deprecation-warning -jar /app/app.jar
