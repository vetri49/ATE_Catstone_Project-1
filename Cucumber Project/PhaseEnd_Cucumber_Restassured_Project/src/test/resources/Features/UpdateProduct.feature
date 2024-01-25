@tag
Feature: Update a shoe in the store
  I want to test the functionality of updating a shoe in the store

  @tag1 @UpdateRequest
  Scenario: Update a shoe on the website
    Given open the update product base url
    When hit the PUT request to update the shoe with ID 101
    Then the response code should be equal to 200
    And the response should indicate successful update
