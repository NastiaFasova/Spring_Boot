FROM openjdk:11-oracle
ADD target/spring-boot-demo-0.0.1-SNAPSHOT.jar docker-app.jar
ENTRYPOINT ["java", "-jar", "docker-app.jar"]
