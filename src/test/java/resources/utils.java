package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import com.google.gson.Gson;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class utils  {

	public  static RequestSpecification req;
	
	public String getJsonPath(Response response,String key)
	{
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}

	public static String convertFromJSONToPOJO(Object jsonObject) {
		
		 Gson gson = new Gson();
		 String result =   gson.toJson(jsonObject);
		 return result;
		
	}
	
	public RequestSpecification requestspecification() throws IOException {
		
		if(req == null) {
		
		   PrintStream printStream = new PrintStream(new File("logs.text"));
		   req =  new RequestSpecBuilder().setBaseUri(globalValue("baseUrl"))
				   .setContentType(ContentType.JSON)
				   .addQueryParam("key", "qaclick123")
				   .addFilter(RequestLoggingFilter.logRequestTo(printStream))
				   .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
				   .build();
		return req;
		}
		return req;
	}
	
	public static String globalValue(String key) throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\kill001\\Desktop\\framework\\RestAssuredPractise\\src\\test\\java\\resources\\global.properties");
		properties.load(fileInputStream);
		return	properties.getProperty(key);
		
		
	}
	
	
}
