
# Solar Farm Starter
## Database 
[ ] Choose a project
    * I'll be using Solar Farm Starter Project 

[X] Create a database schema 
    * create a one-table database schema to manage your model
    * Use the model's properties to determine column names and data types. 
    * Decide on primary key and key strategy (auto_increment or app generated)

## Set Up 
* [X] Add the appropriate Spring denpendencies to pom.xml (See Lesson: jdbcTemplate)
* [X] If the project doesn't use Spring annotation configuration, update it to use annotation configuration 
* [X] Create a new concrete implementation of the project's repository interface that uses `JbdcTemplate` 
    * start with empty method bodies that return a defult value 

## Implement Methods
* [X] Implement the JdbcTemplate repository `findAll()` method
  * Add `findAll()` to the interface 
  * Add a constructor that accepts `JdbcTemplate` as a dependency
  * Implement the `findAll()` method (you can implement this and leave it empty for now)

* [X] Revisit testing out app using the `App.main()`

## Set Up Testing  
* [X] Create a test database to safely execute tests and establish known good state

* [ ] Generate test class for the `JdbcTemplate` repository

* [ ] Create a test-specific Spring configuration -- `DbTestConfig` class in lesson

* [ ] Implement a `shouldFindAll()` test

## Next Methods

* [ ] Implement and test the `findBySection()` repository method

* [ ] Implement and test the `create()` repository method

* [ ] Update the `shouldFindAll()` test assertions to check for a specific model instance

* [ ] Implement and test the `update()` repository method

* [ ] Implement and test the `deleteById()` repository method

## Cleanup

* [ ] Remove DataAccessException class
* [ ] Remove SolarPanelFileRepository class