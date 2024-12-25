package practiseUdemy;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;


public class practice {
	String  placeId ;
	
	@Test(priority =  1)
	
	public void AddPlace() {
		
	baseURI = "https://rahulshettyacademy.com";
	
	String response = given().header("Content-Type","application/json")
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
	.when()
	.log().all()
	.post("/maps/api/place/add/json?key=qaclick123")
	.then()
	.log()
	.all()
	.assertThat()
	.statusCode(200).extract().asString();
		
	JsonPath jsp = new JsonPath(response);
	placeId = jsp.getString("place_id");
	System.out.println(placeId);	
	}
	
	
	@Test(priority = 2)
	public void getAddPlace() {
		
		baseURI = "https://rahulshettyacademy.com";
		
		String response = given().header("Content-Type","application/json")
		.queryParam("key", "qaclick123")
		.queryParam("place_id", placeId )
		.when()
		.log()
		.all()
		.get("/maps/api/place/get/json?place_id="+placeId+"&key=qaclick123")
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200).extract().asString();
			
//		JsonPath jsp = new JsonPath(response);
//		String  placeId = jsp.getString("place_id");
//		System.out.println(placeId);
		
			
		}
	
	@Test(priority = 3)
	public void updateplace() {
		baseURI = "https://rahulshettyacademy.com/";
		 String responseupdate = given().header("Content-Type","application/json")
		.queryParam("place_id",placeId )
		.queryParam("key", "qaclick123")
		.when()
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+""
				+ "\"address\":\"80 winter walk, india\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").
		log().all()
		.put("maps/api/place/update/json?place_id=\""+placeId+"\"&key=qaclick123")
		.then().log().all().statusCode(200)
		.extract().asString();
		 
//			JsonPath jspp = new JsonPath(responseupdate);
//			String  address = jspp.getString("address");
//			System.out.println(address);
	}
	
	
	@Test(priority = 4)
	
	public void deletePlace() {
		
		baseURI = "https://rahulshettyacademy.com";
		
	String deleteresponse =	given().header("Content-Type", "application/json")
		.queryParam("key", "qaclick123")
		.body("{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+placeId+"\"\r\n"
				+ "}")
		.when()
		.delete("/maps/api/place/delete/json?key=qaclick123")
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().asString();
	}
	
	
}
