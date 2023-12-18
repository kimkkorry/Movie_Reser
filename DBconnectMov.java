package Movie_Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBconnectMov {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	private static final String url = "jdbc:mysql://localhost:3306/Tiketing?severTimezone=UTC";
	private static final String user = "root";
	private static final String pass = "1234";
	
	public DBconnectMov() {
		conn=getConnection();
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			//1. 드라이버 세팅
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. Connection 획득
			conn = DriverManager.getConnection(url, user, pass);
			//System.out.println("DB Connection 성공");
		} catch (Exception e) {
			System.out.println("DB작업중 문제 발생: " + e.getMessage());
		}
		return conn;
	}
	public void insertMoviecenter(String movcenter, String movpoint, String movaddress) {
	      // ===========DB파일===========
	      // 3. Statement 생성
	      try {
	        stmt = conn.createStatement();

	        String sql = "INSERT INTO moviecenter (movcenter, movpoint, movaddress) VALUES ('"+
	           movcenter + "','"+ movpoint + "','"+ movaddress + "')";
	         stmt.executeUpdate(sql);
	         System.out.printf("%s 영화관 등록이 완료되었습니다.\n", movcenter);
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updateMoviecenter(String movcenter, String movpoint, String movaddress) {
		//============== DB작업 ================
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE moviecenter SET movpoint = '%s', movaddress = '%s' WHERE movcenter = '%s'", 
movpoint, movaddress, movcenter);
		stmt.executeUpdate(sql);
		System.out.printf("%s 영화관 수정이 완료되었습니다.\n", movpoint);
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
		//=========================================
	}
	public void deleteMoviecenter(String movcenter, String movpoint) {
		//================= DB작업 ===============
		try {
			stmt = conn.createStatement();
			String sql = String.format("DELETE FROM moviecenter WHERE movcenter = '%s'",movcenter);
			stmt.executeUpdate(sql);
			System.out.printf("%s 영화관 삭제가 완료되었습니다.\n", movpoint);
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		// ===========================================
	}
	public void insertMovie(String movcode, String movname, String movthema, int runtime, int agegroup, float resrate) {
	      // ===========DB파일===========
	      // 3. Statement 생성
	      try {
	        stmt = conn.createStatement();

	        String sql = String.format("INSERT INTO movies (movcode, movname, movthema, runtime, agegroup, resrate) VALUES ('%s','%s','%s','%s','%s','%s')"
	        		, movcode,movname, movthema, runtime, agegroup, resrate);
	         stmt.executeUpdate(sql);
	         System.out.printf("%s 영화 정보 등록이 완료되었습니다.\n", movname);
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updateMovie(String movcode, String movname, String movthema, int runtime, int agegroup, float resrate) {
		//============== DB작업 ================
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE movies SET movname = '%s' , movthema = '%s', runtime = '%s' , agegroup = '%s', resrate = '%s' WHERE movcode = '%s'", 
movname, movthema, runtime, agegroup, resrate, movcode);
		stmt.executeUpdate(sql);
		System.out.printf("%s 영화 정보 수정이 완료되었습니다.\n", movname);
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
		//=========================================
	}
	public void deleteMovie(String movcode, String movname) {
		//================= DB작업 ===============
		try {
			stmt = conn.createStatement();
			String sql = String.format("DELETE FROM movies WHERE movcode = '%s'",movcode);
			stmt.executeUpdate(sql);
			System.out.printf("%s 영화 정보 삭제가 완료되었습니다.\n", movname);
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		// ===========================================
	}
	public void insertTheater(String thecode, String thename, String movcenter, int price, int cleantime) {
	      // ===========DB파일===========
	      // 3. Statement 생성
	      try {
	        stmt = conn.createStatement();

	        String sql =String.format("INSERT INTO theater (thecode, thename, movcenter, price, cleantime) VALUES ('%s','%s','%s','%s','%s')"
	        		, thecode, thename, movcenter, price, cleantime);
	         stmt.executeUpdate(sql);
	         System.out.printf("%s 영화관의 %s 상영 정보 등록이 완료되었습니다.\n", movcenter, thename);
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updateTheater(String thecode, String thename, String movcenter, int price, int cleantime) {
		//============== DB작업 ================
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE Theater SET thename = '%s' , movcenter = '%s', price = '%s', cleantime = '%s' WHERE thecode = '%s'", 
thename, movcenter, price, cleantime, thecode);
		stmt.executeUpdate(sql);
		System.out.printf("%s 영화관의 %s 상영 정보 수정이 완료되었습니다.\n", movcenter, thename);
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
		//=========================================
	}
	public void deleteTheater(String movcenter, String thecode, String thename) {
		//================= DB작업 ===============
		try {
			stmt = conn.createStatement();
			String sql = String.format("DELETE FROM Theater WHERE thecode = '%s'", thecode);
			stmt.executeUpdate(sql);
			System.out.printf("%s 영화관의 %s 상영 정보 삭제가 완료되었습니다.\n", movcenter, thename);
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		// ===========================================
	}
	public void insertreservations(String bnumber, String ucseats, String id, String movcode, String screencode, String thecode) {
	      // ===========DB파일===========
	      // 3. Statement 생성
	      try {
	        stmt = conn.createStatement();

	        String sql = String.format("INSERT INTO reservations (bnumber, ucseats, id, movcode, screencode, thecode) VALUES ('%s','%s','%s','%s','%s','%s')"
	        		, bnumber, ucseats, id, movcode, screencode, thecode);
	         stmt.executeUpdate(sql);
	         System.out.printf("%s님의 예약이 완료되었습니다.\n", id);
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updatereservations(String bnumber, String ucseats, String id, String movcode, String screencode, String thecode) {
		//============== DB작업 ================
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE reservations SET ucseats = '%s', id = '%s' , movcode = '%s', screencode = '%s', thecode = '%s' WHERE bnumber = '%s'", 
ucseats, id, movcode, screencode, thecode, bnumber);
		stmt.executeUpdate(sql);
		System.out.printf("%s님의  예약 수정이 완료되었습니다.\n", id);
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
		//=========================================
	}
	public void deletereservations(String bnumber, String id) {
		//================= DB작업 ===============
		try {
			stmt = conn.createStatement();
			String sql = String.format("DELETE FROM reservations WHERE bnumber = '%s'" , bnumber);
			stmt.executeUpdate(sql);
			System.out.printf("%s님의 예약 삭제가 완료되었습니다.\n", id);
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		// ===========================================
	}
	public void insertuserinfo(String id, String pass_word, String name_, String cellphone, String birth, String ninkname) {
	      // ===========DB파일===========
	      // 3. Statement 생성
	      try {
	        stmt = conn.createStatement();

	        String sql = String.format("INSERT INTO userinfo (id, pass_word, name_, cellphone, birth, ninkname) VALUES ('%s','%s','%s','%s','%s','%s')"
	        		, id, pass_word, name_, cellphone, birth, ninkname);
	         stmt.executeUpdate(sql);
	         System.out.printf("%s님 회원 등록이 완료되었습니다.\n", name_);
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updateuserinfo(String id, String pass_word, String name_, String cellphone, String birth, String ninkname) {
		//============== DB작업 ================
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE userinfo SET pass_word = '%s' , name_ = '%s', cellphone = '%s', birth = '%s', ninkname = '%s' WHERE id = '%s'", 
pass_word, name_, cellphone, birth, ninkname, id);
		stmt.executeUpdate(sql);
		System.out.printf("%s님 회원 수정이 완료되었습니다.\n", name_);
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
		//=========================================
	}
	public void deleteuserinfo(String name_, String id) {
		//================= DB작업 ===============
		try {
			stmt = conn.createStatement();
			String sql = String.format("DELETE FROM userinfo WHERE id = '%s'" , id);
			stmt.executeUpdate(sql);
			System.out.printf("%s님 회원 삭제가 완료되었습니다.\n", name_);
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		// ===========================================
	}
	public void insertscreen(String screencode, String movcode, String thecode, String starttime, String endtime, String seats) {
	      // ===========DB파일===========
	      // 3. Statement 생성
	      try {
	        stmt = conn.createStatement();

	        String sql =String.format("INSERT INTO screen (screencode, movcode, thecode, starttime, endtime, seats) VALUES ('%s','%s','%s','%s','%s','%s')"
	        		, screencode, movcode, thecode, starttime, endtime, seats);
	         stmt.executeUpdate(sql);
	         System.out.printf("%s ~ %s 상영 영화 등록이 완료되었습니다.\n", starttime, endtime);
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updatescreen(String screencode, String movcode, String thecode, String starttime, String endtime, String seats) {
		//============== DB작업 ================
		try {
			stmt = conn.createStatement();
			String sql = String.format("UPDATE screen SET movcode = '%s' , thecode = '%s', starttime = '%s', endtime = '%s', seats = '%s' WHERE screencode = '%s'", 
movcode, thecode, starttime, endtime, seats, screencode);
		stmt.executeUpdate(sql);
		System.out.printf("%s ~ %s 상영 영화 수정이 완료되었습니다.\n", starttime, endtime);
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
		//=========================================
	}
	public void deletescreen(String screencode) {
		//================= DB작업 ===============
		try {
			stmt = conn.createStatement();
			String sql = String.format("DELETE FROM screen WHERE screencode = '%s'" , screencode);
			stmt.executeUpdate(sql);
			System.out.printf("영화 상영 삭제가 완료되었습니다.\n");
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		// ===========================================
	}

	public ArrayList<userinfo> getuserinfo() {
		
		ArrayList<userinfo> AddrList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select *from userinfo;\r\n"+"";
			
			rs = stmt.executeQuery(sql);
			
			//System.out.println("============ 주소록 목록 ================");
			while(rs.next()) {
				String id = rs.getString("id");
				String pass_word = rs.getString("pass_word");
				String name_ = rs.getString("name_");
				String cellphone = rs.getString("cellphone");
				String birth = rs.getString("birth");
				String ninkname = rs.getString("ninkname");
				
				userinfo a1 = new userinfo(id, pass_word, name_, cellphone,birth,ninkname);
				AddrList.add(a1);
			}
		}catch (Exception e) {
			System.out.println("list DB 작업중 문제 발생!");
			e.printStackTrace();
		}
		return AddrList;
		
	}
public ArrayList<movies> getmovies() {
		
		ArrayList<movies> AddrList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select *from movies;\r\n"+"";
			
			rs = stmt.executeQuery(sql);
			
			//System.out.println("============ 주소록 목록 ================");
			while(rs.next()) {
				String movcode = rs.getString("movcode");
				String movname = rs.getString("movname");
				String movthema = rs.getString("movthema");
				int runtime = rs.getInt("runtime");
				int agegroup = rs.getInt("agegroup");
			float resrate = rs.getFloat("resrate");
				
				movies a1 = new movies(movcode, movname, movthema, runtime, agegroup, resrate);
				AddrList.add(a1);
			}
		}catch (Exception e) {
			System.out.println("list DB 작업중 문제 발생!");
			e.printStackTrace();
		}
		return AddrList;
		
	}
public ArrayList<moviecenter> getmoviecenter() {
	
	ArrayList<moviecenter> AddrList = new ArrayList<>();
	try {
		stmt = conn.createStatement();
		String sql = "select *from moviecenter;\r\n"+"";
		
		rs = stmt.executeQuery(sql);
		
		//System.out.println("============ 주소록 목록 ================");
		while(rs.next()) {
			String movcenter = rs.getString("movcenter");
			String movpoint = rs.getString("movpoint");
			String movaddress = rs.getString("movaddress");
			
			moviecenter a1 = new moviecenter(movcenter, movpoint, movaddress);
			AddrList.add(a1);
		}
	}catch (Exception e) {
		System.out.println("list DB 작업중 문제 발생!");
		e.printStackTrace();
	}
	return AddrList;
	
}
public ArrayList<Theater> getTheater() {
	
	ArrayList<Theater> AddrList = new ArrayList<>();
	try {
		stmt = conn.createStatement();
		String sql = "select *from theater;\r\n"+"";
		
		rs = stmt.executeQuery(sql);
		
		//System.out.println("============ 주소록 목록 ================");
		while(rs.next()) {
			String thecode = rs.getString("thecode");
			String thename = rs.getString("thename");
			String movcenter = rs.getString("movcenter");
			int price = rs.getInt("price");
			int cleantime = rs.getInt("cleantime");
			
			Theater a1 = new Theater(thecode, thename, movcenter, price, cleantime);
			AddrList.add(a1);
		}
	}catch (Exception e) {
		System.out.println("list DB 작업중 문제 발생!");
		e.printStackTrace();
	}
	return AddrList;
	
}
public ArrayList<screen> getscreen() {
	
	ArrayList<screen> AddrList = new ArrayList<>();
	try {
		stmt = conn.createStatement();
		String sql = "select *from screen;\r\n"+"";
		
		rs = stmt.executeQuery(sql);
		
		//System.out.println("============ 주소록 목록 ================");
		while(rs.next()) {
			String screencode = rs.getString("screencode");
			String movcode = rs.getString("movcode");
			String thecode = rs.getString("thecode");
			String starttime = rs.getString("starttime");
			String endtime = rs.getString("endtime");
			String seats = rs.getString("seats");
			
			screen a1 = new screen(screencode, movcode, thecode, starttime, endtime, seats);
			AddrList.add(a1);
		}
	}catch (Exception e) {
		System.out.println("list DB 작업중 문제 발생!");
		e.printStackTrace();
	}
	return AddrList;
	
}
public ArrayList<reservations> getreservations() {
	
	ArrayList<reservations> AddrList = new ArrayList<>();
	try {
		stmt = conn.createStatement();
		String sql = "select *from reservations;\r\n"+"";
		
		rs = stmt.executeQuery(sql);
		
		//System.out.println("============ 주소록 목록 ================");
		while(rs.next()) {
			String bnumber = rs.getString("bnumber");
			String ucseats = rs.getString("ucseats");
			String id = rs.getString("id");
			String movcode = rs.getString("movcode");
			String screencode = rs.getString("screencode");
			String thecode = rs.getString("thecode");
			
			reservations a1 = new reservations(bnumber, ucseats, id, movcode, screencode, thecode);
			AddrList.add(a1);
		}
	}catch (Exception e) {
		System.out.println("list DB 작업중 문제 발생!");
		e.printStackTrace();
	}
	return AddrList;
	
}
	
}
class Theater{
	private String thecode;
	private String thename;
	private String movcenter;
	private int price;
	private int cleantime;
	
	public Theater(String thecode, String thename, String movcenter, int price, int cleantime){
		this.thecode = thecode;
		this.thename = thename;
		this.movcenter = movcenter;
		this.price = price;
		this.cleantime = cleantime;
	}

	public String getThecode() {
		return thecode;
	}

	public void setThecode(String thecode) {
		this.thecode = thecode;
	}

	public String getThename() {
		return thename;
	}

	public void setThename(String thename) {
		this.thename = thename;
	}

	public String getMovcenter() {
		return movcenter;
	}

	public void setMovcenter(String movcenter) {
		this.movcenter = movcenter;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCleantime() {
		return cleantime;
	}

	public void setCleantime(int cleantime) {
		this.cleantime = cleantime;
	}


}
class movies{
	private String movcode;
	private String movname;
	private String movthema;
	private int runtime;
	private int agegroup;
	private float resrate;
	
	public movies(String movcode, String movname, String movthema, int runtime, int agegroup, float resrate) {
		this.movcode = movcode;
		this.movname = movname;
		this.movthema = movthema;
		this.runtime = runtime;
		this.resrate = resrate;
		this.agegroup = agegroup;
	}

	public String getMovcode() {
		return movcode;
	}

	public int getAgegroup() {
		return agegroup;
	}

	public void setAgegroup(int agegroup) {
		this.agegroup = agegroup;
	}

	public void setMovcode(String movcode) {
		this.movcode = movcode;
	}

	public String getMovname() {
		return movname;
	}

	public void setMovname(String movname) {
		this.movname = movname;
	}

	public String getMovthema() {
		return movthema;
	}

	public void setMovthema(String movthema) {
		this.movthema = movthema;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public float getResrate() {
		return resrate;
	}

	public void setResrate(float resrate) {
		this.resrate = resrate;
	}


}
class screen{
	private String screencode;
	private String movcode;
	private String thecode;
	private String starttime;
	private String endtime;
	private String seats;
	
	public screen(String screencode, String movcode, String thecode, String starttime, String endtime, String seats) {
		this.screencode = screencode;
		this.movcode = movcode;
		this.thecode = thecode;
		this.starttime = starttime;
		this.endtime = endtime;
		this.seats = seats;
	}

	public String getScreencode() {
		return screencode;
	}

	public void setScreencode(String screencode) {
		this.screencode = screencode;
	}

	public String getMovcode() {
		return movcode;
	}

	public void setMovcode(String movcode) {
		this.movcode = movcode;
	}

	public String getThecode() {
		return thecode;
	}

	public void setThecode(String thecode) {
		this.thecode = thecode;
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

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}


}
class reservations{
	private String bnumber;
	private String ucseats;
	private String id;
	private String movcode;
	private String screencode;
	private String thecode;
	
	public reservations(String bnumber, String ucseats, String id, String movcode, String screencode, String thecode) {
		this.bnumber = bnumber;
		this.ucseats = ucseats;
		this.id = id;
		this.movcode = movcode;
		this.screencode = screencode;
		this.thecode = thecode;
	}

	public String getBnumber() {
		return bnumber;
	}

	public void setBnumber(String bnumber) {
		this.bnumber = bnumber;
	}

	public String getUcseats() {
		return ucseats;
	}

	public void setUcseats(String ucseats) {
		this.ucseats = ucseats;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovcode() {
		return movcode;
	}

	public void setMovcode(String movcode) {
		this.movcode = movcode;
	}

	public String getScreencode() {
		return screencode;
	}

	public void setScreencode(String screencode) {
		this.screencode = screencode;
	}

	public String getThecode() {
		return thecode;
	}

	public void setThecode(String thecode) {
		this.thecode = thecode;
	}
	

}
class moviecenter{
	private String movcenter;
	private String movpoint;
	private String movaddress;
	
	public moviecenter(String movcenter, String movpoint, String movaddress) {
		this.movcenter = movcenter;
		this.movpoint = movpoint;
		this.movaddress = movaddress;
	}

	public String getMovcenter() {
		return movcenter;
	}

	public void setMovcenter(String movcenter) {
		this.movcenter = movcenter;
	}

	public String getMovpoint() {
		return movpoint;
	}

	public void setMovpoint(String movpoint) {
		this.movpoint = movpoint;
	}

	public String getMovaddress() {
		return movaddress;
	}

	public void setMovaddress(String movaddress) {
		this.movaddress = movaddress;
	}


}
class userinfo{
	private String id;
	private String pass_word;
	private String name_;
	private String cellphone;
	private String birth;
	private String ninkname;
	
	public userinfo(String id, String pass_word, String name_, String cellphone, String birth, String ninkname) {
		this.id = id;
		this.pass_word = pass_word;
		this.name_ = name_;
		this.cellphone = cellphone;
		this.birth = birth;
		this.ninkname = ninkname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getName_() {
		return name_;
	}

	public void setName_(String name_) {
		this.name_ = name_;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getNinkname() {
		return ninkname;
	}

	public void setNinkname(String ninkname) {
		this.ninkname = ninkname;
	}


}
