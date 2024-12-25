package practiseUdemy;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.restassured.path.json.JsonPath;


public class apiJiraEndtoEnd {

	public String id ;
	public String Key;
	
	@Test(priority = 1)
	
	public void CreateAnIssue() {
	
	baseURI = "https://sudarshankillekar.atlassian.net/";
	
   String createIssueResponse =	given().header("Content-Type","application/json")
	.header("Authorization", "Basic c3VkYXJzaGFua2lsbGVrYXIxOTk4QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBxaXJTLUNhVUNjWFJCazNBalJ5MHl5R0JaaDdoWWJhYnZQR2NqaEFTSUhIRmtuRXpwUEtLX09CaDkzTTFHcmZCaE5HVDAtS1NWQS1YZXdTWXFGaEltQTE0dHRsa0RRaVgxMlppdlNGODVkMmRGbUtNcGlKVElzVGhGTWlGY05wMlU5cFRQRjhaRlRGV0RBZko0SkJZcWFTSUExcnJsQ0FVNDhjdHJ1OXBHN2M9OTA5MzRDNDg=")
	.body("{\r\n"
			+ "    \"fields\": {\r\n"
			+ "       \"project\":\r\n"
			+ "       {\r\n"
			+ "          \"key\": \"SCRUM\"\r\n"
			+ "       },\r\n"
			+ "       \"summary\": \"REST ye merry gentlemen.\",\r\n"
			+ "       \"issuetype\": {\r\n"
			+ "          \"name\": \"Bug\"\r\n"
			+ "       }\r\n"
			+ "   }\r\n"
			+ "}\r\n"
			+ "    ").
	when().log().all()
	.post("//rest/api/3/issue")
	.then()
	.assertThat().statusCode(201).extract().asString();
		
	  JsonPath js = new JsonPath(createIssueResponse);
	  id  = js.getString("id");
	  Key  =js.getString("Key");
	  System.out.println(id);
	
	  
	
	} 		
		
	
	@Test(priority = 2)
	
	public void getIssueDetails() {
		
		baseURI = "https://sudarshankillekar.atlassian.net/";
		
	     String getIssuedetails =	given()
	    .header("Authorization", "Basic c3VkYXJzaGFua2lsbGVrYXIxOTk4QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBxaXJTLUNhVUNjWFJCazNBalJ5MHl5R0JaaDdoWWJhYnZQR2NqaEFTSUhIRmtuRXpwUEtLX09CaDkzTTFHcmZCaE5HVDAtS1NWQS1YZXdTWXFGaEltQTE0dHRsa0RRaVgxMlppdlNGODVkMmRGbUtNcGlKVElzVGhGTWlGY05wMlU5cFRQRjhaRlRGV0RBZko0SkJZcWFTSUExcnJsQ0FVNDhjdHJ1OXBHN2M9OTA5MzRDNDg=")
	    .pathParam("key", id)
		.when()
		.log().all()
		.get("/rest/api/3/issue/{key}")
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.body("id", equalTo(id))
		.body("Key", equalTo(Key))
		.extract().asString(); 
	
	  
		
	}
		
	@Test(priority = 3)	
	public void updatedataInIssue() {
	
		baseURI = "https://sudarshankillekar.atlassian.net/";
		
		given().header("Authorization", "Basic c3VkYXJzaGFua2lsbGVrYXIxOTk4QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBxaXJTLUNhVUNjWFJCazNBalJ5MHl5R0JaaDdoWWJhYnZQR2NqaEFTSUhIRmtuRXpwUEtLX09CaDkzTTFHcmZCaE5HVDAtS1NWQS1YZXdTWXFGaEltQTE0dHRsa0RRaVgxMlppdlNGODVkMmRGbUtNcGlKVElzVGhGTWlGY05wMlU5cFRQRjhaRlRGV0RBZko0SkJZcWFTSUExcnJsQ0FVNDhjdHJ1OXBHN2M9OTA5MzRDNDg=")
		.header("Content-Type","application/json")
		.pathParam("key", id)
		.when().log().all()
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"description\": {\r\n"
				+ "            \"version\": 1,\r\n"
				+ "            \"type\": \"doc\",\r\n"
				+ "            \"content\": [\r\n"
				+ "                {\r\n"
				+ "                    \"type\": \"paragraph\",\r\n"
				+ "                    \"content\": [\r\n"
				+ "                        {\r\n"
				+ "                            \"type\": \"text\",\r\n"
				+ "                            \"text\": \"test 2\"\r\n"
				+ "                        }\r\n"
				+ "                    ]\r\n"
				+ "                }\r\n"
				+ "            ]\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}")
		
		.put("rest/api/3/issue/{key}")
		.then().log().all()
		.assertThat().statusCode(204).extract().response().asString();
		
		
		
	}
		
	@Test(priority = 4)
	
	public void deleteAnIssue() {
		
		baseURI = "https://sudarshankillekar.atlassian.net/";
		given().header("Authorization", "Basic c3VkYXJzaGFua2lsbGVrYXIxOTk4QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBxaXJTLUNhVUNjWFJCazNBalJ5MHl5R0JaaDdoWWJhYnZQR2NqaEFTSUhIRmtuRXpwUEtLX09CaDkzTTFHcmZCaE5HVDAtS1NWQS1YZXdTWXFGaEltQTE0dHRsa0RRaVgxMlppdlNGODVkMmRGbUtNcGlKVElzVGhGTWlGY05wMlU5cFRQRjhaRlRGV0RBZko0SkJZcWFTSUExcnJsQ0FVNDhjdHJ1OXBHN2M9OTA5MzRDNDg=")
		.header("Content-Type","application/json")
		.pathParam("key", id)
		.when().log().all()
		.delete("rest/api/3/issue/{key}")
		.then()
		.assertThat().statusCode(204).extract().response().asString();
		
		
		
	}
	
	
	
	
	
}
