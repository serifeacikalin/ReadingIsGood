FROM openjdk:11

COPY books-api-0.0.1-SNAPSHOT.jar booksapi.jar

ENTRYPOINT ["java","-jar","/booksapi.jar"]