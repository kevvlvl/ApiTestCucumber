Feature: Obtain stocks values
  As a user, obtain present time value of certain stocks from the API MicronautRestApi

  Scenario: User calls the API to obtain stocks values
    Given a healthy API service
    When a user performs a GET request to stocks endpoint
    Then the status code is 200
    And response body includes the following items
    | symbol | name              |
    | ABC.YZ | Some fake Company |