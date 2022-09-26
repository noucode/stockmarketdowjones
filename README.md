# stockmarketdowjones

### Description
Dow Jones Index is the project called stockmarketdowjones. 
I am using an in-memory database, and for that reason, anytime you start the application, a batch job is launch to load the data in the Database.

Beside that I used the following Tech Stack:
- Java 8, for coding
- Maven 3, for building the code
- Spring Boot 2, Spring Data JPA and Spring Batch
- Git and GitHub for source control.

I did not test as much as I would like because I did not have time. 
For the same reason I did not comment much and also did not design in a way that Unit tests can run independently of other tests. 
Also there is a couple of hard-coding still for the same reason.

### Running the Project
- Just clone https://github.com/noucode/stockmarketdowjones.git locally.
- Make sure you checkout on the master branch.
- From the project root folder optionally run the following command: 
```$ mvn clean install```
- Then run the following command: $ java -jar target/stockmarketdowjones-0.0.1-SNAPSHOT.war
- Or the following one: $ mvn spring-boot:run

### Querying the Database
You can use either Curl or Postmman to query the database;

- Examples GET requests: http://localhost:8080/dowjonesdatas/
http://localhost:8080/dowjonesdatas/AA

- Examples POST request: http://localhost:8080/upload-file

