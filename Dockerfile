FROM openjdk:11
ADD target/ExamSpringBoot-0.0.1-SNAPSHOT.jar ExamSpringBoot.jar
EXPOSE 8889
ENTRYPOINT ["java", "-jar", "ExamSpringBoot.jar"]