package googlemappojo;

import java.util.Arrays;
import java.util.List;
import java.util.List;

public class AddPlacepojo {

	private location location;
	private int accuracy;
	private String name;
	private String phone_number;
	private List<String> types;
	private String website;
	private String language;
	
//	public AddPlacepojo(googlemappojo.location location, int accuracy, String name, String phone_number,
//			List<String> types, String website, String language) {
//		super();
//		this.location = location;
//		this.accuracy = accuracy;
//		this.name = name;
//		this.phone_number = phone_number;
//		this.types = types;
//		this.website = website;
//		this.language = language;
//	}

	public location getLocation() {
		return location;
	}

	public void setLocation(location location) {
		this.location = location;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public List<String> getTypes() {
		return types;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "AddPlacepojo [location=" + location + ", accuracy=" + accuracy + ", name=" + name + ", phone_number="
				+ phone_number + ", types=" + types + ", website=" + website + ", language=" + language + "]";
	}

	
	
	
	
}
