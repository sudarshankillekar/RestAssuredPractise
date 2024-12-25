package practiseUdemy;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

//import static io.restassured.*;
public class reUsableMethods {
//
	public static JsonPath rawToJson(String jsonResponse) {	
		JsonPath json = new JsonPath(jsonResponse);
	return json;	
	}
	
}
