package com.simplilearn.restassuredtest;
import static org.hamcrest.CoreMatchers.equalTo;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateProduct {

	private static final String BASE_URL="http://localhost:9010";
	private static Logger logger=Logger.getLogger(UpdateProduct.class);
	String response=null;
	@Test(description="Test to update the product in the store")
	public void testGetProduct() {
		try {
			int id = 101;
            String image= "update image";
            String name = "updated Shoe";
            String category = " updated Runnings";
            int sizes = 12;
            int price = 1099;
		logger.info("Start :: Test to update the product in the store");
		
		RestAssured.given().baseUri(BASE_URL)
		.queryParam("id",id).queryParam("image",image)
        .queryParam("name",name).queryParam("category",category)
        .queryParam("sizes",sizes).queryParam("price",price)
		.when().put("/update-shoe").then()
		.assertThat().statusCode(200)
		.body("message", equalTo("updated Shoe Updated Successfully."));
		
		
		response = RestAssured.given().baseUri(BASE_URL)
				.queryParam("id",id).queryParam("image",image)
		        .queryParam("name",name).queryParam("category",category)
		        .queryParam("sizes",sizes).queryParam("price",price)
		        .when().put("/update-shoe").getBody().asString();
	}catch(Exception e) {
		logger.error("Exception Object :: "+e.toString());
		logger.error("End Exception :: "+e.getLocalizedMessage());
	}
		logger.info("Reponse :: "+response);
		logger.info("End :: Test to update the product in the store");
	}
}
