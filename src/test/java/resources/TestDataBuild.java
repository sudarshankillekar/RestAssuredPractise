package resources;

import java.util.ArrayList;
import java.util.List;

import googlemappojo.AddPlacepojo;
import googlemappojo.location;

public class TestDataBuild  {

	public AddPlacepojo AddPlacedata(String name ,String number,String langauge) {
		
		List<String > al = new ArrayList<>();
		 al.add("test1");
		 al.add("test2");
		 
  AddPlacepojo addPlacepojo = new AddPlacepojo();	
 location location = new location();
location.setLat(98743);
location.setLng(56789);
addPlacepojo.setAccuracy(40);
addPlacepojo.setLanguage(langauge);
addPlacepojo.setName(name);
addPlacepojo.setPhone_number(number);
addPlacepojo.setWebsite("google");
addPlacepojo.setTypes(al);
addPlacepojo.setLocation(location);	


return addPlacepojo;
		
	}
	
	
}
