FROM openjdk
ADD target/HarryPotter_Bookstore-0.0.1-SNAPSHOT.jar HarryPotter_Bookstore-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","HarryPotter_Bookstore-0.0.1-SNAPSHOT.jar"]