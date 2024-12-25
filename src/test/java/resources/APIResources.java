package resources;

public enum APIResources {

	AddPlaceAPI("maps/api/place/add/json"),
	GetPlaceApi("maps/api/place/get/json"),
	UpdatePlaceApi("maps/api/place/update/json"),
	DeletePlaceApi("maps/api/place/delete/json");
	
	private String resource;
	
	APIResources(String resources) {
		this.resource = resources;
	}
	
	public String getresources() {
		return resource;
	}
	
}
