package com.simplilearn.cucumber.stepdefinitions;

import org.hamcrest.Matchers;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateshoeSteps {

	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	private String BASE_URL = "http://localhost:9010";
	
	@Given("open the update product base url")
	public void open_the_update_product_base_url() {
	    request=RestAssured.given().baseUri(BASE_URL);
	}

	   
	    @When("hit the PUT request to update the shoe with ID {int}")
	    public void hit_the_put_request_to_update_the_shoe_with_id(Integer shoeId) {
	    	
	    	int id = shoeId;
            String image= "update image";
            String name = "updated Shoe";
            String category = " updated Runnings";
            int sizes = 12;
            int price = 1099;
	        response =request
	        		.queryParam("id",id).queryParam("image",image)
	                .queryParam("name",name).queryParam("category",category)
	                .queryParam("sizes",sizes).queryParam("price",price)
	                .when().put( "/update-shoe?id=" );
	    }

	    @Then("the response code should be equal to {int}")
	    public void the_response_code_should_be_equal_to(Integer expectedStatusCode) {
	        json=response.then().statusCode(expectedStatusCode);
	    }

	    @Then("the response should indicate successful update")
	    public void the_response_should_indicate_successful_update() {
	           System.out.println(json.toString());
	    }
}
