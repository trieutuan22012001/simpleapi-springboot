FROM openjdk:17-jdk-slim
LABEL maintainer="author@tuantrancode.com"
VOLUME /data/postgess
ADD build/libs/spring-boot-postgresql-project-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/app.jar"]