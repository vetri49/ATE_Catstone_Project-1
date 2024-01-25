package com.simplilearn.cucumber.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostRequestSteps {

	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	private String requestBody;
	
	private String BASE_URL = "http://localhost:9010";
	
	@Given("Open the API base URL")
	public void open_the_api_base_url() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	@Given("Enter the shoe details")
	public void enter_the_shoe_details() {
		 requestBody = "id=" + 101 + "&image=image_url&name=Sample Shoes&category=Sports Shoe&sizes=9&price=1999";
	}

	@When("Hit the POST request to create a new shoe")
	public void hit_the_post_request_to_create_a_new_shoe() {
		 int id = 101;
         String image_url = "image_url";
         String name = "sampleShoe";
         String category = "Runnings";
         int sizes = 9;
         int price = 1000;
	    response=request.queryParam("id",id).queryParam("image",image_url)
                .queryParam("name",name).queryParam("category",category)
                .queryParam("sizes",sizes).queryParam("price",price).when().post("/add-shoe");
	}

	@Then("The response code should be {int}")
	public void the_response_code_should_be(Integer code) {
	    json=response.then().statusCode(code);
	    System.out.println(json);
	}

	@Then("Print the result of adding new shoe")
	public void print_the_result_of_adding_new_shoe() {
	    System.out.println(response.getBody().asString());
	}
}
