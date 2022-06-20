@employees
Feature: Testing the employee features on the Dummy Rest API application

  Scenario:Create a new employee & verify if the employee is added
    When I create a new employee by providing the information name salary and age
    Then I verify that the new employee is created

  Scenario:Updating the employee created and verify it is updated with status 200
    When I update the employee with name salary and age
    Then I verify that the employee information is updated

  Scenario:Deleting the employee created and verify it is deleted
    When I delete the created employee with id
    Then I verify that the employee is deleted and get the status 200

