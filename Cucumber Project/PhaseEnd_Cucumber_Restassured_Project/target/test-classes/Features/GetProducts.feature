Feature: Retrieve all products from the sports shoe store
  As a user,
  I want to retrieve the list of all available shoes from the sports shoe store,
  So that I can browse and choose the desired products.

  @tag @GetProducts
  Scenario: Retrieve all products successfully
    Given I am interested in viewing the available shoes
    When I send a request to retrieve the list of products
    Then I should receive a successful response with status code 200
    And the response should contain a valid list of sports shoes
