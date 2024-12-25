package googlemappojo;

public class deletePlacePojo {

	
	private String place_id;

	public deletePlacePojo(String place_id) {
		super();
		this.place_id = place_id;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	@Override
	public String toString() {
		return "deletePlacePojo [place_id=" + place_id + "]";
	}
	
	
}
