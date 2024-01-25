package com.simplilearn.cucumber.stepdefinitions;
import static org.hamcrest.CoreMatchers.containsString;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProductSteps {
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	private String BASE_URL = "http://localhost:9010";
	
	
	@Given("there is an existing shoe with ID {int}")
	public void there_is_an_existing_shoe_with_id(Integer int1) {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@When("hit the DELETE request for the shoe with ID {int}")
	public void hit_the_delete_request_for_the_shoe_with_id(Integer shoeId) {
	    response=request.delete("/delete-shoe?id="+shoeId);
	}

	@Then("the response code should be {int}")
	public void the_response_code_should_be(Integer code) {
	    json=response.then().statusCode(code);
	}


@Then("the response should indicate successful deletion")
public void the_response_should_indicate_successful_deletion() {
    response.then().body("message", containsString("Shoe with ID 101 Deleted Successfully"));
}

}
