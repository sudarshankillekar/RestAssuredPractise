package practiseUdemy;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class sumValidation {


	JsonPath path = new JsonPath(payload.purchaseresponse());
    int count =  path.getInt("courses.size()");
	
	
	@Test
	public void assertpurchaseAmount() {
		
		
		int sum = 0;
		for(int i = 0 ;i<count;i++) {
		int	price  =	 path.get("courses["+i+"].price");
		int	copies  =	 path.get("courses["+i+"].copies");	
		int totolamount = price*copies;
		sum = sum + totolamount;
		
			}
		System.out.println(sum );		 
		int actualamount =  path.getInt("dashboard.purchaseAmount")	;
		System.out.println("actual amount"+ sum);
		Assert.assertEquals(actualamount, sum);
		
			 }	
		
	}
	

