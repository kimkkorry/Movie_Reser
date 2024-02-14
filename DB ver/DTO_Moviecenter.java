package TeamC_Movie;

public class DTO_Moviecenter {
	private String centercode;
	private String centername;
	private String address;

	public DTO_Moviecenter(String centercode, String centername,String address) {
		this.centercode = centercode;
		this.centername = centername;
		this.address = address;
		
	}

	public String getCentercode() {
		return centercode;
	}


	public void setCentercode(String centercode) {
		this.centercode = centercode;
	}


	public String getCentername() {
		return centername;
	}


	public void setCentername(String centername) {
		this.centername = centername;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

}
