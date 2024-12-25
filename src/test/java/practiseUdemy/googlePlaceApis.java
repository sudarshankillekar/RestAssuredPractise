package practiseUdemy;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class googlePlaceApis {

 @Test
	public void AddPlaceApi() {
		
		baseURI = "https://rahulshettyacademy.com";
		
	String response =	given().header("Content-Type","application/json")
		.queryParam("key", "qaclick123")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}")
		.when().log().all()
		.post("/maps/api/place/add/json?key=qaclick123")
		.then().log().all().
		assertThat().statusCode(200).extract().response().asString();
		
		
	}
	
	
	
	
	
	
	
}
