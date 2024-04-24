FROM openjdk:8
EXPOSE 8080
ADD target/Harrypotter.jar Harrypotter.jar
ENTRYPOINT ["java","-jar","/Harrypotter.jar"]