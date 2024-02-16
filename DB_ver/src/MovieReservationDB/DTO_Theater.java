package MovieReservationDB;

public class DTO_Theater {
	private String theatercode; // 상영관 고유코드
	private String theatername; // 상영관 이름 
	private String centercode; // Moviecenter Table primary key
	private int seatprice; // 상영관별 금액
	private int cleantime; // 청소시간 30분
	private String totalseats; // I09
	
	
	public DTO_Theater(String theatercode, String theatername, String centercode, int seatprice, int cleantime, String totalseats) {
		this.theatercode = theatercode;
		this.theatername = theatername;
		this.centercode = centercode;
		this.seatprice = seatprice;
		this.cleantime = cleantime;
		this.totalseats = totalseats;
		
	}

	public String getTheatercode() {
		return theatercode;
	}

	public void setTheatercode(String theatercode) {
		this.theatercode = theatercode;
	}

	public String getTheatername() {
		return theatername;
	}

	public void setTheatername(String theatername) {
		this.theatername = theatername;
	}

	public String getCentercode() {
		return centercode;
	}

	public void setCentercode(String centercode) {
		this.centercode = centercode;
	}

	public int getSeatprice() {
		return seatprice;
	}

	public void setSeatprice(int seatprice) {
		this.seatprice = seatprice;
	}

	public int getCleantime() {
		return cleantime;
	}

	public void setCleantime(int cleantime) {
		this.cleantime = cleantime;
	}

	public String getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(String totalseats) {
		this.totalseats = totalseats;
	}

	public String subString(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
}
