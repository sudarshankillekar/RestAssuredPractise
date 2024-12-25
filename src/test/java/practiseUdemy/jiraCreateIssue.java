package practiseUdemy;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;


public class jiraCreateIssue {

	
	@Test()
	
	public void createIssueTest() {
		
		baseURI = "https://sudarshankillekar.atlassian.net/";
		
String getResponseId =		given().headers("Authorization","Basic c3VkYXJzaGFua2lsbGVrYXIxOTk4QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBxaXJTLUNhVUNjWFJCazNBalJ5MHl5R0JaaDdoWWJhYnZQR2NqaEFTSUhIRmtuRXpwUEtLX09CaDkzTTFHcmZCaE5HVDAtS1NWQS1YZXdTWXFGaEltQTE0dHRsa0RRaVgxMlppdlNGODVkMmRGbUtNcGlKVElzVGhGTWlGY05wMlU5cFRQRjhaRlRGV0RBZko0SkJZcWFTSUExcnJsQ0FVNDhjdHJ1OXBHN2M9OTA5MzRDNDg=")
		.headers("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"this is coming from restassured , for jira Api\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "    ")
		.log()
		.all()
		.when()
	    .post("/rest/api/3/issue")
	    .then().log().all()
	    .assertThat().statusCode(201).extract().response().asString();

       JsonPath jsonPath = new JsonPath(getResponseId);
       String id = jsonPath.get("id");
	System.out.println(id+" id generated successfully");	
	
	
String dataoutput =	given().headers("Authorization","Basic c3VkYXJzaGFua2lsbGVrYXIxOTk4QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBxaXJTLUNhVUNjWFJCazNBalJ5MHl5R0JaaDdoWWJhYnZQR2NqaEFTSUhIRmtuRXpwUEtLX09CaDkzTTFHcmZCaE5HVDAtS1NWQS1YZXdTWXFGaEltQTE0dHRsa0RRaVgxMlppdlNGODVkMmRGbUtNcGlKVElzVGhGTWlGY05wMlU5cFRQRjhaRlRGV0RBZko0SkJZcWFTSUExcnJsQ0FVNDhjdHJ1OXBHN2M9OTA5MzRDNDg=")
	.headers("X-Atlassian-Token","no-check").pathParam("key", id)
	.headers("Content-Type","multipart/form-data; boundary=<calculated when request is sent>")
	.multiPart("file",new File("C:\\Users\\kill001\\Pictures\\Screenshots\\Untitled.png"))
	.post("rest/api/3/issue/{key}/attachments")
	.then().log().all().assertThat().statusCode(200).extract().response().asString();
	}
	
	
	
}
