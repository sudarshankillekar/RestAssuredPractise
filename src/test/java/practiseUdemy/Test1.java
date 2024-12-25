package practiseUdemy;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.payload;
import utils.serialization;


public class Test1 {

	
	@Test(dataProvider  = "bookdata")
	
	public void verifyAddBook(String isbn, String aisle) {
	
		baseURI = "https://rahulshettyacademy.com";
         String jsonResponse =		given().log().all().header("Content-Type","application/json")
		.body(payload.AddBook(isbn,aisle))
		 .when()
		.post("/Library/Addbook.php")
		.then().log().all()
		.assertThat()
		.statusCode(200).extract().response().asPrettyString();
		
      JsonPath js   =     reUsableMethods.rawToJson(jsonResponse);
        String id    =    js.get("ID");
        System.out.println(id);             
   
	}
	
	@DataProvider(name = "bookdata")
	public Object[][] getData() {	
		return new Object[][] {{"QWEW","1234"},{"sdfd","4523"},{"sdas","123"}};
	}
}
