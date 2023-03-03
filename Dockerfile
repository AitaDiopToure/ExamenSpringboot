FROM openjdk:11
ADD target/ExamenSpringboot-0.0.1-SNAPSHOT.jar ExamenSpringboot.jar
EXPOSE 8889
ENTRYPOINT ["java", "-jar", "ExamenSpringboot.jar"]