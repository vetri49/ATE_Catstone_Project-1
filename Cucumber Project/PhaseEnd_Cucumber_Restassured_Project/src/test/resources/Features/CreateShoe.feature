@tag
Feature: Create a new shoe in the store
  I want to test the functionality of creating a new shoe

  @tag1
  Scenario: Create a new shoe on the website
    Given Open the API base URL
    And Enter the shoe details
    When Hit the POST request to create a new shoe
    Then The response code should be 200
    And Print the result of adding new shoe
