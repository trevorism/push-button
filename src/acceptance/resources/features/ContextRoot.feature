Feature: Context Root of Push Button
  In order to use the push button API, it must be available

  Scenario: Root of the API
    Given the application is alive
    When I navigate to "http://click.trevorism.com/api"
    Then then a link to the help page is displayed

  Scenario: Root of the API HTTPS
    Given the application is alive
    When I navigate to "https://click.trevorism.com/api"
    Then then a link to the help page is displayed

  Scenario: Root of the API on app engine
    Given the application is alive
    When I navigate to "https://trevorism-pushbutton.appspot.com/api"
    Then then a link to the help page is displayed

  Scenario: Ping
    Given the application is alive
    When I ping the application deployed to "http://click.trevorism.com/api"
    Then pong is returned, to indicate the service is alive

  Scenario: Ping HTTPS
    Given the application is alive
    When I ping the application deployed to "https://click.trevorism.com/api"
    Then pong is returned, to indicate the service is alive

  Scenario: Ping on app engine
    Given the application is alive
    When I ping the application deployed to "https://trevorism-pushbutton.appspot.com/api"
    Then pong is returned, to indicate the service is alive
