package MovieReservationDB;

public class DTO_Screen {
	private String screencode;
	private String moviecode;
	private String theatercode;
	private String starttime;
	private String endtime;
	private String moviename;
	private String theatername;
	private int soldseats;

	public DTO_Screen(String screencode,String moviename,String theatername) {
		this.screencode = screencode;
		this.moviename = moviename;
		this.theatername = theatername;
	}
	
	public DTO_Screen(String screencode, String moviecode, String theatercode, String starttime, String endtime,
			int soldseats) {
		this.screencode = screencode;
		this.moviecode = moviecode;
		this.theatercode = theatercode;
		this.starttime = starttime;
		this.endtime = endtime;
		this.soldseats = soldseats;
	}

	public String getScreencode() {
		return screencode;
	}

	public void setScreencode(String screencode) {
		this.screencode = screencode;
	}

	public String getMoviecode() {
		return moviecode;
	}

	public void setMoviecode(String moviecode) {
		this.moviecode = moviecode;
	}

	public String getTheatercode() {
		return theatercode;
	}

	public void setTheatercode(String theatercode) {
		this.theatercode = theatercode;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public int getSoldseats() {
		return soldseats;
	}

	public void setSoldseats(int soldseats) {
		this.soldseats = soldseats;
	}
}