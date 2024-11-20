package practiseUdemy;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import utils.payload;
import utils.serialization;


public class Test1 {

	@Test
	public void verifyAddBook() {
	
		baseURI = "https://rahulshettyacademy.com";
         String jsonResponse =		given().log().all().header("Content-Type","application/json")
		.body(payload.AddBook())
		.post("/Library/Addbook.php")
		.then().log().all()
		.assertThat()
		.statusCode(200).extract().response().toString();
		
      JsonPath js   = reUsableMethods.rawToJson(jsonResponse);
        String id    =    js.get("ID");
        System.out.println(id);             
   
	}
	
}
