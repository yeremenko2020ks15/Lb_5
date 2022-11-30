FROM openjdk:11
EXPOSE 8081
ADD target/springboot-images-new.jar lb-6.jar
ENTRYPOINT ["java", "-jar", "/lb-6.jar"]