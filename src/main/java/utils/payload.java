package utils;

public class payload {

	
	public static String AddBook(String isbn, String aisle) {
		
	String addBookBody =	"{\r\n"
		+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
		+ "\"isbn\":\""+isbn+"\",\r\n"
		+ "\"aisle\":\""+aisle+"\",\r\n"
		+ "\"author\":\"John foer\"\r\n"
		+ "}";
	
	return addBookBody;
	}
	
}
