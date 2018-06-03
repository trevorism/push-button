Feature: Invoke a push button
  One can successfully invoke a button. Correctly configured buttons succeed, incorrectly configured buttons fail.

  Scenario: Invoke a valid button
    Given the application is alive
    When a valid button is invoked
    Then a successful response is returned

  Scenario: Invoke an invalid button
    Given the application is alive
    When an invalid button is invoked
    Then a failure response is returned
