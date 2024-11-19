package com.api.tests;

import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;

public class Delete_request {

	JsonPath jsonPath;
	
	@Test
	public void delete_request() {
		
    baseURI = "https://reqres.in/api/";
    
    given()
    .header(new Header("Host", "reqres.in"))
    .delete("users/2")
    .then()
    .assertThat()
    .log()
    .all()
    .and()
    .statusCode(204); 		
		
	}
	
	
}
