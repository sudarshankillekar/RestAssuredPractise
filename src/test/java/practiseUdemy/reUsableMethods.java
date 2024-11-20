package practiseUdemy;

import io.restassured.path.json.JsonPath;

//import static io.restassured.*;
public class reUsableMethods {
//
	public static JsonPath rawToJson(String response) {	
   JsonPath json = new JsonPath(response);
	return json;	
	}
	
}
