package com.simplilearn.restassuredtest;
import static org.hamcrest.CoreMatchers.equalTo;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteProduct {

	private static final String BASE_URL="http://localhost:9010";
	private static Logger logger=Logger.getLogger(DeleteProduct.class);
	String response=null;
	@Test(description="Test to delete product from the store")
	public void testDeleteProduct() {
		try {
		logger.info("Start :: Test to delete product from the store");
		int id=201;
		RestAssured.given().baseUri(BASE_URL)
		.when().delete("/delete-shoe?id="+id).then().statusCode(200).and()
		.body("message",equalTo("Shoe with ID 201 Deleted Successfully."));
		
		
		response = RestAssured.given().baseUri(BASE_URL)
		.when().delete("/delete-shoe?id="+id).getBody().asString();
	}catch(Exception e) {
		logger.error("Exception Object :: "+e.toString());
		logger.error("End Exception :: "+e.getLocalizedMessage());
	}
		logger.info("Reponse :: "+response);
		logger.info("End :: Test to delete product from the store");
	}
}
