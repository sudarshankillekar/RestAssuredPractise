package com.api.tests;


import static io.restassured.RestAssured.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.github.fge.jsonschema.main.JsonSchema;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.postRequestPojo;
import utils.serialization;

public class api_test {
  
static	JsonPath jsonPath;
	
   File JsonSchema = new File("C:\\Users\\Lenovo\\Desktop\\Framework\\REST_ASSURED_CRUD_BDD\\src\\test\\Schemoresponse\\post_create_response.json");
	
	@Test
	public void Create_API_REquest() {
	 
	     baseURI = "https://reqres.in/api/";	
		
	     jsonPath =  	given()
		.header(new Header("Content-Type", "application/json"))
		.body(serialization.convertFromJSONToPOJO(new postRequestPojo("sudarshan", "killekar")))
		.when()
		.log().all()
		.post("/users")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.time(Matchers.lessThan(5000L))
		.and()
		.body("name",equalTo("sudarshan"))
		.body(JsonSchemaValidator.matchesJsonSchema(JsonSchema))
		.extract().jsonPath();		
	   
	}
	
}
