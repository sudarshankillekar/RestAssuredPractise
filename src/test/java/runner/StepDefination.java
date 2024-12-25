package runner;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.utils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apiguardian.api.API;
import org.junit.Assert;

import static org.junit.Assert.*;

import googlemappojo.AddPlacepojo;
import googlemappojo.deletePlacePojo;
import googlemappojo.location;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefination extends utils {
	 RequestSpecification reqq ;
	 ResponseSpecification responseSpec;
	 Response response ;
	 TestDataBuild dataBuild = new TestDataBuild();
	 deletePlacePojo deletePlacePojo;
	 static String place_id;
	 
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload(String name ,String number,String langauge) throws IOException {

         


          reqq = given().spec(requestspecification()).body(dataBuild.AddPlacedata(name,number,langauge));
		   
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resoucre,String method) {
	
	 APIResources apiResources          =           APIResources.valueOf(resoucre);
		apiResources.getresources();
	responseSpec = new ResponseSpecBuilder().
				 expectStatusCode(200)
				 .expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST")) 
		 response  =      reqq.
				when()
				.post(apiResources.getresources()).then()
				.spec(responseSpec).extract().response();
		else if(method.equalsIgnoreCase("GET"))
			response  =      reqq.
			when()
			.get(apiResources.getresources()).then()
			.spec(responseSpec).extract().response();
		}
		
	

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statuscode) {
	  
		   int statusscode  =      response.getStatusCode();
		  // assertEquals(statusscode,statuscode);
		   Assert.assertEquals(statusscode, statusscode);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String status, String ok) {

		Assert.assertEquals(getJsonPath(response, status), ok);
		
	}
	
	@Then("verify place id created that map's to {string} created using {string}")
	public void verify_place_id_created_that_map_s_to_created_using(String resoucre, String resoucre1) throws IOException {
	   
	    place_id =	getJsonPath(response, "place_id");
		reqq = given().spec(requestspecification()).queryParam("place_id", place_id);
		user_calls_with_post_http_request(resoucre1,"GET");
		String Name =    getJsonPath(response, "name");
		Assert.assertEquals(resoucre,Name);
	}
	
	@Given("Deletplace payload")
	public void deletplace_payload() throws IOException {
	    
		reqq = given().spec(requestspecification()).body(convertFromJSONToPOJO(new deletePlacePojo(place_id)));
		
	}
	
}
