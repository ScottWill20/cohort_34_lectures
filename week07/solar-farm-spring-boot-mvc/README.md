
# Solar Farm API

## Exercise: Schema and JdbcTemplate Exercise

### Database

* [x] Choose a project
    * I'll be using the Solar Farm Starter project

* [x] Create a database schema
    * Create a one-table database schema to manage your model
    * Use the model's properties to determine column names and data types
    * Decide on a primary key and key strategy (auto_increment or application-generated)

### Set Up

* [x] Add the appropriate Spring dependencies to pom.xml. (See Lesson: JdbcTemplate)
* [x] If the project doesn't use Spring annotation configuration, update it to use annotation configuration
* [x] Create a new concrete implementation of the project's repository interface that uses `JdbcTemplate`
    * Start with empty method bodies that return a default value

### Tasks

* [x] Implement the JdbcTemplate repository `findAll()` method
  * Add `findAll()` to the interface
  * Add a constructor that accepts `JdbcTemplate` as a dependency
  * Implement the `findAll()` method

* [x] Revisit testing out app using the `App.main()`

* [x] Create a test database to safely execute tests and establish known good state

* [x] Generate test class for the `JdbcTemplate` repository

* [x] Create a test-specific Spring configuration `DbTestConfig` class

* [x] Implement a `shouldFindAll()` test

* [x] Implement and test the `findBySection()` repository method

* [x] Implement and test the `create()` repository method

* [x] Update the `shouldFindAll()` test assertions to check for a specific model instance

* [x] Implement and test the `update()` repository method

* [x] Implement and test the `deleteById()` repository method

* [ ] Answer unanswered standup questions

* [ ] Show how to use the `@Configuration` annotation

## Exercise: From Console to the Web

### Goals

* Convert an existing database-backed console application to an HTTP service
* Test the service

### Tasks

_Use the same project from the one-table schema and JdbcTemplate repository exercise_

* [ ] Initial set-up
  * Add Spring Boot parent, MVC, and DevTools dependencies to `pom.xml`
  * Update the `App` class
  * Configure the repositories `DataSource` in `application.properties`
  * Stub out the RestController (just add the class)
  * Add a `requests.http` file (empty file)

* [ ] Show how to use environment variables to set the `DataSource` `application.properties` property values

* [ ] Implement retrieving records ("find all" and "find by section")
  * Add the GET endpoint method
  * Write HTTP requests for manual testing
  * Test using REST Client in VS Code
  * Review data in the database using Workbench
  
* [ ] Implement retrieving a single record
  * Add the GET endpoint method (200 OK for success, 404 NOT FOUND for failures)
  * Write an HTTP request for manual testing
  * Test using REST Client in VS Code
  * Review data in the database using Workbench
  
* [ ] Implement creating records
  * Add the POST endpoint method
  * Write the HTTP request for manual testing
  * Test using REST Client in VS Code
  * Review data in the database using Workbench
  
* [ ] Returning error messages to the client
  * Update the POST endpoint to return a list of error messages

* [ ] Implement updating records
  * Add the PUT endpoint method
  * Write the HTTP request for manual testing
  * Test using REST Client in VS Code
  * Review data in the database using Workbench

* [ ] Updating the result type
  * Add the `ResultType` enum
  * Add the new `Result<T>` class
  * Update the service class to use the new result type
  
* [ ] Implement deleting records
  * Add the DELETE endpoint method
  * Write the HTTP request for manual testing
  * Test using REST Client in VS Code
  * Review data in the database using Workbench

* [ ] Update JdbcTemplate repository tests to use Spring Boot
  * Update the `pom.xml` file
  * Delete the `DbTestConfig` class
  * Switch to using `@SpringBootTest`
  * Add test `application.properties` file
  * Update how known good state is being managed


  
_Mocking isn't a required part of this week's assessment..._
  
* [ ] Update service tests to use mocking
  * Convert the test class to use `@SpringBootTest`
  * Update the "find*" tests to use mocking 

* [ ] Update more unit tests to use mocking
  * Delete or comment out the test double





* [ ] Implement global exception handling with `@ControllerAdvice` and `@ExceptionHandler`





_These tasks are optional..._

* [ ] Write controller tests
  * _Writing controller tests isn't required for the assessment_

* [ ] Review profiles
  * You can use this as a way to control which dependencies are loaded
  * _Good to have an awareness of this but you're not likely to have a user for it in class_

* [ ] CORS
  * _We'll come back to this later when we're working with React_

* [ ] Clean-up
  * Remove the file repository and its test class
  * Remove the data files
  * Remove the custom DataAccessException class
  * Remove the ui package