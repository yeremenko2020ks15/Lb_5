FROM openjdk:11
FROM maven:3.3.3
ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn -q dependency:resolve
ADD src /tmp/build/src
# Створіть програму
RUN cd /tmp/build && mvn -q -DskipTests=true package \
# Копіювати результат компіляції у
#вказаний каталог
&& mv target/*.jar /app.jar \
# Очистити сліди компіляції
&& cd / && rm -rf /tmp/build
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app"]