package com.simplilearn.cucumber.stepdefinitions;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetUserSteps {
	
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	private String BASE_URL = "http://localhost:9010";
	
	@Given("I am interested in viewing the registered users")
	public void i_am_interested_in_viewing_the_registered_users() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("I send a request to retrieve the users")
	public void i_send_a_request_to_retrieve_the_users() {
	    response=request.when().get("/get-users");
	}

	@Then("I want to receive a successful response with status code {int}")
	public void i_want_to_receive_a_successful_response_with_status_code(Integer code) {
	    json=response.then().statusCode(code);
	    System.out.println(json.toString());
	}
	

	@Then("the response should contain a valid list of users")
	public void the_response_should_contain_a_valid_list_of_users() {
		response.then().body("users", Matchers.notNullValue());
	}

}
