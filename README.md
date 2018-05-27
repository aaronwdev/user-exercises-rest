# user-exercises-rest

### Purpose of project
A very simple Spring rest webservice to help aid other example test frameworks in this repository.

### Installing and Running

By default port 8080 will be used. 

Import as maven project.

To run create a run configuration:
 Main Class:            "com.williams.userexercisesrest.UserExercisesRestApplication"
 Working Directory:     "[Your Project Location]\user-exercises-rest"
 Classpath:             "user-exercises-rest"
 
 Or you can run in the terminal `mvn spring-boot:run -Drun.jvmArguments="-Dserver.port=8080"`

### Running Tests
All unit tests
`mvn test "-Dtest=*UnitTest.java"`

All integration tests
`mvn test "-Dtest=*IntegrationTest.java"`


### API Documentation
With the service running you can visit http://localhost:8080/swagger-ui.html

### Querying In Memory h2 Database
With the service running visit http://localhost:8080/h2-console/login.do and make sure the JDBC URL is set as jdbc:h2:mem:testdb

Example queries listed below. Please remember the service starts with no data injection script you need to run the tests to create data!

```
    SELECT * FROM EXERCISE;
    SELECT * FROM USER;
    SELECT * FROM USER_EXERCISE_LOG;
 ```

### Supporting Repositories
The following testing frameworks can be used to test this service when running.

Rest-assured testing framework: https://bitbucket.org/aaronmwilliams/user-exercises-restassured-testing

### IDE Plugins
The project uses Lombok. So you will need to install this plugin otherwise you will see compile errors.