FROM openjdk:8
EXPOSE 8080
ADD target/HarryPotter_Bookstore.jar HarryPotter_Bookstore.jar
ENTRYPOINT ["java","-jar","/HarryPotter_Bookstore.jar"]