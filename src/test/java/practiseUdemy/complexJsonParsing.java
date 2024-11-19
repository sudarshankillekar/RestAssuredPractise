package practiseUdemy;

import io.restassured.path.json.JsonPath;

public class complexJsonParsing {

	public static void main(String[] args) {
		
		JsonPath path = new JsonPath(payload.purchaseresponse());
		          int count =  path.getInt("courses.size()");
	      String coursetitlet =	path.getString("courses[0,1,2].title");
	      String courseprice =	path.getString("courses[0,1,2].price");
		 System.out.println(coursetitlet);
		 System.out.println(courseprice);
		 
		 
		 //title + price
		 for(int i = 0 ;i<count;i++) {
		String titles =	 path.get("courses["+i+"].title");
		System.out.println(path.get("courses["+i+"].price").toString());
		
		 System.out.println(titles);
		 
		
		 }
		 
		 //number of copies sold for rpa course
		 
		 for(int i = 0 ;i<count;i++) {
				String titles =	 path.get("courses["+i+"].title");
				
				if(titles.equalsIgnoreCase("RPA")) {
			   int copiescount =	path.getInt("courses["+i+"].copies");
			   System.out.println(copiescount);
			   break;
				}
				 
				
				 }
		 
		
	}

}
