package com.pojotest;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import courseDetailsPojo.Api;
import courseDetailsPojo.Courses;
import courseDetailsPojo.WebAutomation;
import courseDetailsPojo.getCoursePojo;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.restassured.path.json.JsonPath;

public class authTest {

	
	@Test
	public void test() {
		
	String [] titles = {"Selenium Webdriver Java","Cypress","Protractor"};	
	baseURI = "https://rahulshettyacademy.com";
		
	String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
	 .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
	 .formParam("grant_type", "client_credentials")
	 .formParam("scope", "trust")
	 .when().log().all()
	 .post("/oauthapi/oauth2/resourceOwner/token").then().log().all().extract().asString();
	
	 JsonPath jsonPath = new JsonPath(response);
	 String token =  jsonPath.getString("refresh_token");
	 
	 getCoursePojo gc =  given().queryParam("access_token",token )
	 .when().log().all()
	 .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(getCoursePojo.class);
	
	 System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	
	 List<Api> apicourses = gc.getCourses().getApi();
	
	 for(int i = 0;i<apicourses.size();i++) {
		 if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
			 System.out.println(apicourses.get(i).getPrice());
		 }
	 }
	 List<String> a = new ArrayList<>();
 	 List<WebAutomation> web  = gc.getCourses().getWebAutomation();
	 for(int i = 0 ;i<web.size();i++) {
		 System.out.println(web.get(i).getCourseTitle());
		 a.add(web.get(i).getCourseTitle());
	 }
	             Arrays.asList(titles);
	 Assert.assertEquals(a, Arrays.asList(titles));
	}
	
}
