@tag
Feature: Delete a shoe from the store
  I want to test the functionality of deleting a shoe from the store

  @tag1
  Scenario: Delete a shoe from the website
    Given Open the API base URL
    And there is an existing shoe with ID 101
    When hit the DELETE request for the shoe with ID 101
    Then the response code should be 200
    And the response should indicate successful deletion
