Feature: Crud on a button
  I can perform CRUD and List on an arbitrary object

  Scenario: Create a test object
    Given the application is alive
    And a test button is defined
    And the button is created
    Then the button can found by listing all objects
    And the button can be retrieved by name

  Scenario: Update a test object
    Given the application is alive
    And a test button is defined
    And the button is created
    When the button is updated
    Then the button can be retrieved by name
    And the button reflects the update

  Scenario: Delete a test object
    Given the application is alive
    And a test button is defined
    And the button is created
    When the button is deleted
    Then the button cannot be retrieved

  Scenario: An invalid object throws an error
    Given the application is alive
    And an invalid test button is defined
    When the invalid test button is created
    Then an error is thrown, indicating the failure