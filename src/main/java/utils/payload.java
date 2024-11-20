package utils;

public class payload {

	
	public static String AddBook() {
		
	String addBookBody =	"{\r\n"
		+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
		+ "\"isbn\":\"bcd\",\r\n"
		+ "\"aisle\":\"2926\",\r\n"
		+ "\"author\":\"John foer\"\r\n"
		+ "}";
	
	return addBookBody;
	}
	
}
