package pojo;

public class update_put_request_pojo {
 
	String name ;
	String job ;
	
	public update_put_request_pojo(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "update_put_request_pojo [name=" + name + ", job=" + job + "]";
	}
	
}
