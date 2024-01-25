package com.simplilearn.restassuredtest;

import static org.hamcrest.CoreMatchers.equalTo;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AddProduct {
    private static String BASE_URL = "http://localhost:9010";
    private static Logger logger = Logger.getLogger(AddProduct.class);
    String response = null;

    @Test(description = "Test to create a product")
    public void testAddProduct() {
        try {
            logger.info("Start :: Test to create a product ");
            int id = 101;
            String image_url = "image_url";
            String name = "sampleShoe";
            String category = "Runnings";
            int sizes = 9;
            int price = 1000;

            RestAssured.given().baseUri(BASE_URL)
                    .queryParam("id",id).queryParam("image",image_url)
                    .queryParam("name",name).queryParam("category",category)
                    .queryParam("sizes",sizes).queryParam("price",price)
                    .when().post("/add-shoe")
                    .then().assertThat().statusCode(200)
                    .body("message",equalTo("sampleShoe Added Successfully."));

            response = RestAssured.given().baseUri(BASE_URL)
            		.queryParam("id",id).queryParam("image",image_url)
                    .queryParam("name",name).queryParam("category",category)
                    .queryParam("sizes",sizes).queryParam("price",price)
                    .when().post("/add-shoe")
                    .getBody().asString();
        } catch (Exception e) {
            logger.error("Exception Object :: " + e.toString());
            logger.error("End Exception :: " + e.getLocalizedMessage());
        }

        logger.info("Response :: " + response);
        logger.info("End :: Test to create a product");
    }
}
