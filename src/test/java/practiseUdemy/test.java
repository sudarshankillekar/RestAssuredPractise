package practiseUdemy;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.sql.Driver;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class test {

	public static void main(String[] args) {
		
		baseURI = "https://rahulshettyacademy.com";
		
	
		
	String response =	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
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
		.when().post("maps/api/place/add/json")
		.then().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
       
	    System.out.println(response);
	
	    JsonPath jsonPath = new JsonPath(response);
	    String placeId = jsonPath.getString("place_id");
	    System.out.println(placeId);
	    
	    //update place
	    String newAdress = "Ho.No :1288 ";
	    given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json")
	    .body("{\r\n"
	    		+ "\"place_id\":\""+placeId+"\",\r\n"
	    		+ "\"address\":\""+newAdress+"\",\r\n"
	    		+ "\"key\":\"qaclick123\"\r\n"
	    		+ "}").
	    when().put("maps/api/place/update/json")
	    .then().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
	    
	
	String getplace =    given().log().all()
	    .queryParam("place_id",placeId)
	    .queryParam("key", "qaclick123")
	    .when().get("maps/api/place/get/json")
	    .then()
	    .assertThat()
	    .log()
	    .all()
	    .statusCode(200)
	    .extract()
	    .response().asString();
	    
	    JsonPath js = new JsonPath(getplace);
	    String actualAddress = js.getString("address");
	    System.out.println(actualAddress);
	    Assert.assertEquals(actualAddress,newAdress );
	    
	}
	

}
