# stockmarketdowjones

## Description
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

## Building the Project on local machine
- Navigate to: https://github.com/noucode/stockmarketdowjones.git 
- Select the master branch.
- Clone the project locally:
  ```
  $ git clone https://github.com/noucode/stockmarketdowjones.git
  ```
- From the project root folder run the following command: 
  ```
  $ mvn clean install
  ```

## Running the Project
- **On Local Machine:**
  - *Either run the following command rom the project directory:*
    ```
    $ java -jar stockmarketdowjones-0.0.1-SNAPSHOT.war
    ```
  - *Or run the following command:*
    ```
    $ mvn spring-boot:run
    ```
- **On Pre-production Server Machine:**
  - *Running the Application in the Background as Linux Service:*
    ```
    $ sudo su - srvportal
    $ sudo systemctl start portalbatchjobservice
    ```
  - *Running the Application in the Foreground:*
    ```
    $ java -jar stockmarketdowjones-0.0.1-SNAPSHOT.war
    ```
- **On Production Server Machine:**
    ```
    $ java -jar stockmarketdowjones-0.0.1-SNAPSHOT.war
    ```


### Querying the Database
You can use either Curl or Postmman to query the database;

- Examples GET requests: http://localhost:8080/dowjonesdatas/
http://localhost:8080/dowjonesdatas/AA

- Examples POST request: http://localhost:8080/upload-file

