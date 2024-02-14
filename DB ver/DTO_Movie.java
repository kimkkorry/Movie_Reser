package TeamC_Movie;

public class DTO_Movie {

	private String moviecode;
	private String moviename;
	private String thema;
	private int runtime;
	private int agegroup;
	private String opendate;
	private float salesrate;
	
	public DTO_Movie(String moviecode, String moviename, String thema, int runtime, int agegroup, String opendate, float salesrate) {
		super();
		this.moviecode = moviecode;
		this.moviename = moviename;
		this.thema = thema;
		this.runtime = runtime;
		this.agegroup = agegroup;
		this.opendate = opendate;
		this.salesrate = salesrate;
	}

	public String getMoviecode() {
		return moviecode;
	}

	public void setMoviecode(String moviecode) {
		this.moviecode = moviecode;
	}

	public String getMoviename() {
		return moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}

	public String getThema() {
		return thema;
	}

	public void setThema(String thema) {
		this.thema = thema;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public int getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(int agegroup) {
		this.agegroup = agegroup;
	}

	public String getOpendate() {
		return opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public float getSalesrate() {
		return salesrate;
	}

	public void setSalesrate(float salesrate) {
		this.salesrate = salesrate;
	}
	
}