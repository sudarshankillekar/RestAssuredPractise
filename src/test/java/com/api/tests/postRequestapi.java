package com.api.tests;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import googlemappojo.AddPlacepojo;
import googlemappojo.location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class postRequestapi {

@Test
	public void sendapirequest() {
	
		
		List<String > al = new ArrayList<>();
		 al.add("test1");
		 al.add("test2");
		 
 AddPlacepojo addPlacepojo = new AddPlacepojo();	
 location location = new location();
 location.setLat(98743);
 location.setLng(56789);
 
 addPlacepojo.setAccuracy(40);
 addPlacepojo.setLanguage("kannada");
 addPlacepojo.setName("sudarshan");
 addPlacepojo.setPhone_number("8904356647");
 addPlacepojo.setWebsite("google");
 addPlacepojo.setTypes(al);
 addPlacepojo.setLocation(location);
 
 
 RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
    .setContentType(ContentType.JSON)
    .addQueryParam("key", "qaclick123")
    .build();
 
 ResponseSpecification responseSpec = new ResponseSpecBuilder().
		 expectStatusCode(200)
		 .expectContentType(ContentType.JSON).build();
 
           
 
 
 RequestSpecification reqq = given().spec(req).body(addPlacepojo);
		   
		Response response  =      reqq.log().all()
		.when()
		.post("/maps/api/place/add/json?key=qaclick123")
		.then()
		.log()
		.all()
		.spec(responseSpec).extract().response();
		
//	JsonPath spJsonPath =	response.asString();
//   
//   String str = spJsonPath.get("id");
//   System.out.println(str);
   
		
		
	}
	
	
}
