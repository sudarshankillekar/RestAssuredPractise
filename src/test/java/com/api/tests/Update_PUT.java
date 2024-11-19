package com.api.tests;

 import static io.restassured.RestAssured.*;

import java.io.File;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import pojo.update_put_request_pojo;
import utils.serialization;
 

public class Update_PUT {

	JsonPath jsonPath;
	File jsonSchema = new File("C:\\Users\\Lenovo\\Desktop\\Framework\\REST_ASSURED_CRUD_BDD\\src\\test\\Schemoresponse\\updateRequestSchemaFile.json");
	
	@Test
	public void update_put_request() {
		
	baseURI = "https://reqres.in/api/"	;
	
	given()
	.header(new Header("Host","reqres.in"))
	.header(new Header("Content-Type", "application/json"))
	.body(serialization.convertFromJSONToPOJO(new update_put_request_pojo("sudarshan", "killeekar")))
    .log().all()
    .put("users/223")
	.then()
	.log().all()
	.assertThat()
	.statusCode(200)
	.time(Matchers.lessThan(5000L))
	.body(JsonSchemaValidator.matchesJsonSchema(jsonSchema))
	.extract();
	
		
		
		
	}
	
	
	
}
