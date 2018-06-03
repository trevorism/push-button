Feature: Crud on a button
  One can perform CRUD and List on an arbitrary object

  Scenario: Create a test button
    Given the application is alive
    And a test button is defined
    And the button is created
    Then the button can found by listing all objects
    And the button can be retrieved by name
    And the button is deleted

  Scenario: Update a test button
    Given the application is alive
    And a test button is defined
    And the button is created
    When the button is updated
    Then the button can be retrieved by name
    And the button reflects the update
    And the button is deleted

  Scenario: Delete a test button
    Given the application is alive
    And a test button is defined
    And the button is created
    When the button is deleted
    Then the button cannot be retrieved

  Scenario: An invalid button throws an error
    Given the application is alive
    And an invalid test button is defined
    When the invalid test button is created
    Then an error is thrown, indicating the failure