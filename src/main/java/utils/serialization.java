package utils;

import com.google.gson.Gson;

import pojo.postRequestPojo;

public class serialization {

	
	
	public static void main(String[] args) {
		
		postRequestPojo postRequestPojo = new postRequestPojo("sudabrshan", "killekar");
		
	           String data = convertFromJSONToPOJO(postRequestPojo);
		       System.out.println(data);
	}
	
	public static String convertFromJSONToPOJO(Object jsonObject) {
		
		 Gson gson = new Gson();
		 String result =   gson.toJson(jsonObject);
		 return result;
		
	}
			
	
	
	
	
}
