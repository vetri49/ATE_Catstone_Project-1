Feature: Retrieve all registered users 
  I want to retrieve the list of all available register users

  @tag @GetProducts
  Scenario: Retrieve all registered users 
    Given I am interested in viewing the registered users
    When I send a request to retrieve the users
    Then I want to receive a successful response with status code 200
    And the response should contain a valid list of users

  
