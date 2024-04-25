FROM openjdk
ADD target/HarryPotter_Bookstore.jar HarryPotter_Bookstore.jar
ENTRYPOINT ["java","-jar","HarryPotter_Bookstore.jar"]