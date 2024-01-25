package com.simplilearn.cucumber.stepdefinitions;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequestSteps {
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "http://localhost:9010";
	
	@Given("I am interested in viewing the available shoes")
	public void i_am_interested_in_viewing_the_available_shoes() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("I send a request to retrieve the list of products")
	public void i_send_a_request_to_retrieve_the_list_of_products() {
	    response=request.when().get("/get-shoes");
	}

	@Then("I should receive a successful response with status code {int}")
	public void i_should_receive_a_successful_response_with_status_code(Integer code) {
	    json=response.then().statusCode(code);
	    System.out.println(json.toString());
	}

	@Then("the response should contain a valid list of sports shoes")
	public void the_response_should_contain_a_valid_list_of_sports_shoes() {
		response.then().body("shoes", Matchers.notNullValue());
	}

}
