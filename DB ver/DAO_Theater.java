package TeamC_Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Theater {
	DBconnect d = new DBconnect();
	Connection con = d.con;
	Statement st = null;
	ResultSet res = null;
	
	public ArrayList<DTO_Theater> getTheater() {
		ArrayList<DTO_Theater> TList = new ArrayList<>();
		
		try {
			st = con.createStatement();
			String sql = "select *from THEATER;\r\n"+"";
		
			res = st.executeQuery(sql);
			
			while(res.next()) {
				String theatercode = res.getString("theatercode");
				String theatername = res.getString("theatername");
				String centercode = res.getString("centercode");
				int seatprice = res.getInt("seatprice");
				int cleantime = res.getInt("cleantime");
				String totalseats = res.getString("totalseats");
				
				DTO_Theater theaters = new DTO_Theater(theatercode, theatername, centercode, seatprice, cleantime, totalseats);
				TList.add(theaters);
				
				} 
			}catch(Exception e) {
				System.out.println("리스트 생성 중 문제가 발생하였습니다. " + e.getMessage());
				e.printStackTrace();
		}
		return TList;
	}
		// Theater List에 해당하는 내용을 출력시키는 메소드
		public void printTheater(ArrayList<DTO_Theater> TheaterList) {
			System.out.printf("\n%-6s\t%-8s\t%-10s\t%-8s\t%-8s\t%-8s", "지점코드", "상영관코드", "상영관 이름", "마지막 좌석", "좌석당 금액", "청소 시간");
			System.out.println("\n=================================================================================");
			for(int i = 0; i < TheaterList.size(); i++) {
				System.out.printf("%-6s\t%-8s\t%-10s\t%-8s\t%-8s\t%-8s\n",
						TheaterList.get(i).getCentercode(), TheaterList.get(i).getTheatercode(), TheaterList.get(i).getTheatername(),
						TheaterList.get(i).getTotalseats(), TheaterList.get(i).getSeatprice()+"원", TheaterList.get(i).getCleantime()+"분");
			}
			System.out.println("=================================================================================");
		}


	
	// THEATER 테이블에 데이터를 추가하는 메소드
	public void insertTheater(String theatercode, String theatername, String centercode, int seatprice, int cleantime, String totalseats) {
		try {
			st = con.createStatement();
			String sql = String.format(
					"INSERT INTO THEATER(theatercode, theatername, centercode, seatprice, cleantime, totalseats) VALUES ('%s', '%s', '%s', '%d', '%d', '%s')"
					, theatercode, theatername, centercode, seatprice, cleantime, totalseats);
			
			//System.out.println(sql);
			st.executeUpdate(sql);
			System.out.printf("\n[%s] 상영관이 등록 완료되었습니다.", theatercode);
			
		} catch (Exception e) {
			System.out.println("상영관 추가 중 문제가 발생하였습니다." + e.getMessage());
			e.printStackTrace();
		}
	} // THEATER 테이블에 데이터를 추가하는 메소드
	
	// THEATER 테이블의 데이터를 수정하는 메소드
	public void changeTheater(String theatercode, String theatername, String centercode, int seatprice, int cleantime, String totalseats) {
		try {
			st = con.createStatement();
			String sql = "UPDATE THEATER SET theatername = '" +
			theatername + "', centercode = '" + centercode + "', seatprice = '" + seatprice + "', cleantime = '" + cleantime 
			+ "', totalseats = '" + totalseats + "' WHERE theatercode = '" + theatercode + "'"; 
			//System.out.println(sql);
			st.executeUpdate(sql);
			System.out.printf("\n지점 [%s]의 [%s] 정보가 수정 완료되었습니다.\n", centercode, theatername);
			
			} catch(Exception e) {
				System.out.println("THEATER 테이블 데이터 수정중 문제가 발생하였습니다." + e.getMessage());
				e.printStackTrace();
			}
	}
	
	// 상영관 삭제하는 메소드
	public void deleteTheater(String theatercode) {
		try{
			st = con.createStatement();
			String sql = "DELETE FROM THEATER WHERE theatercode = '" + theatercode + "'";
			st.executeUpdate(sql);
			System.out.printf("[%s] 상영관이 삭제 완료 되었습니다.", theatercode);
		} catch(Exception e) {
			System.out.println("THEATER 테이블에서 데이터 삭제 도중 문제가 발생하였습니다. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	// 지점코드로 검색하는 메소드
	public void selectCentercode(String centercode) {
		try {
			st = con.createStatement();
			String sql = "SELECT * FROM THEATER WHERE centercode = '" + centercode + "'";
			
			res = st.executeQuery(sql);
			
//			System.out.printf("지점코드 : [%s]에 해당하는 데이터를 출력합니다.\n", centercode);
			System.out.printf("\n%-6s\t%-8s\t%-10s\t%-8s\t%-8s\t%-8s", "지점코드", "상영관코드", "상영관 이름", "마지막 좌석", "좌석당 금액", "청소 시간");
			System.out.println("\n=================================================================================");
						
			while(res.next()) {
				System.out.printf("%-6s\t%-8s\t%-10s\t%-8s\t%-8s\t%-8s\n",
						res.getString("centercode"), res.getString("theatercode"), res.getString("theatername"), 
						res.getString("totalseats"), res.getString("seatprice")+"원", res.getString("cleantime")+"분");
			}
			System.out.println("=================================================================================");
		} catch(Exception e) {
			System.out.println("지점코드로 검색 중 문제가 발생하였습니다. " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void selectTheatercode(String theatercode) {
		try {
			st = con.createStatement();
			String sql = "SELECT * FROM THEATER WHERE theatercode = '" + theatercode + "'";
			res = st.executeQuery(sql);
			
//			System.out.printf("상영관코드 : [%s]에 해당하는 데이터들을 출력합니다.\n", theatercode);
			
			System.out.printf("\n%-6s\t%-8s\t%-10s", "지점코드", "상영관 코드", "상영관 이름");
			System.out.println("\n=================================");
			while(res.next()) {
				System.out.printf("%-6s\t%-8s\t%-10s\n", res.getString("centercode"), res.getString("theatercode"), res.getString("theatername"));
			}
			System.out.println("=================================");
		} catch(Exception e) {
			System.out.println("상영관코드로 검색 중 문제가 발생하였습니다. " + e.getMessage());
			e.printStackTrace();
		}
	}
}