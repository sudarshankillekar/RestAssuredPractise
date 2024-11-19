package com.api.tests;

import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import  org.testng.annotations.Test;

public class READ_GET_REQUEST {

	JsonPath jsonPath ;
	File jsonread = new File("C:\\Users\\Lenovo\\Desktop\\Framework\\REST_ASSURED_CRUD_BDD\\src\\test\\Schemoresponse\\READ_GET.json");
	
	@Test
	public void verifyandtestReadGet() {
		
    baseURI = "https://reqres.in/api/";
    
    given()
    .header(new Header("Host","reqres.in"))
    .when()
    .get("users/1")
    .then()
    .log().all()
    .assertThat()
    .statusCode(200)
    .time(Matchers.lessThan(5000l))
    .body(JsonSchemaValidator.matchesJsonSchema(jsonread))
    .body("data.id", equalTo("1"))
    .extract().jsonPath();	
	}
	
	
	
	
}
