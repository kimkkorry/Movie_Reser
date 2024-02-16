package MovieReservationDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO_Screen {
	DBConnection a = new DBConnection();
	Connection conn = a.conn;
	Statement stmt = null;
	ResultSet rs = null;
	
	public ArrayList<DTO_Screen> getScreen() {
		ArrayList<DTO_Screen> AddrList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "select *from SCREEN;\r\n"+"";	
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String screencode = rs.getString("screencode");
				String moviecode = rs.getString("moviecode");
				String theatercode = rs.getString("theatercode");
				String starttime = rs.getString("starttime");
				String endtime = rs.getString("endtime");
				int soldseats = rs.getInt("soldseats");
				
				DTO_Screen a1 = new DTO_Screen(screencode, moviecode, theatercode, starttime, endtime, soldseats);
				AddrList.add(a1);
			}
		}catch (Exception e) {
			System.out.println("list DB 작업중 문제 발생!");
			e.printStackTrace();
		}
		return AddrList;
		
	}
	
	public void insertscreen(String screencode, String moviecode, String theatercode, String starttime, String endtime, int soldseats) {
	      try {
	    	conn = a.getConnection();
	        stmt = conn.createStatement();
	        String sql =String.format("INSERT INTO SCREEN (screencode, moviecode, theatercode, starttime, endtime, soldseats) VALUES ('%s','%s','%s','%s','%s','%s')"
	        		, screencode, moviecode, theatercode, starttime, endtime, soldseats);
	         stmt.executeUpdate(sql);
	         System.out.printf("\n[ %s ~ %s ] 상영 영화 등록이 완료되었습니다.\n", starttime, endtime);
	      } catch (Exception e) {
	         System.out.println("DB 작업중 문제 발생: " + e.getMessage());
	         e.printStackTrace();
	      }
	   }
	public void updatescreen(String screencode, String moviecode, String theatercode, String starttime, String endtime, int soldseats) {
		try {
			conn = a.getConnection();
			stmt = conn.createStatement();
			String sql = String.format("UPDATE SCREEN SET moviecode = '%s' , theatercode = '%s', starttime = '%s', endtime = '%s', soldseats = '%s' WHERE screencode = '%s'", 
moviecode, theatercode, starttime, endtime, soldseats, screencode);
		stmt.executeUpdate(sql);
		System.out.printf("%s ~ %s 상영 영화 수정이 완료되었습니다.\n", starttime, endtime);
		} catch (Exception e) {
		System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		e.printStackTrace();
		}
	}
	public void deletescreen(String screencode) {
		try {
			conn = a.getConnection();
			stmt = conn.createStatement();
			String sql = "DELETE FROM SCREEN WHERE screencode = " + screencode;
			stmt.executeUpdate(sql);
			System.out.printf("영화 삭제가 완료되었습니다.\n");
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public String lookstartdate(String screencode) {
		try {
			stmt = conn.createStatement();
			String sql = String.format("SELECT DATE_FORMAT(startdate, '%m%d') FROM screen WHERE screencode = '%s'" , screencode);
			rs = stmt.executeQuery(sql);
			String startdate = rs.getString(1);
			return startdate;
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
	public String lookenddate(String screencode) {
		try {
			stmt = conn.createStatement();
			String sql = String.format("SELECT DATE_FORMAT(enddate, '%m%d') FROM screen WHERE screencode = '%s'" , screencode);
			rs = stmt.executeQuery(sql);
			String enddate = rs.getString(1);
			return enddate;
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		return "";
	}
//	public ArrayList<DTO_Screen> gettimetable() {
//		ArrayList<DTO_Screen> timetable = new ArrayList<>();
//		try {
//			stmt = conn.createStatement();
//			String sql = String.format("SELECT DATE_FORMAT(starttime,'%Y-%m-%d') FROM screen WHERE screencode = '%s'" , screencode);	
//			rs = stmt.executeQuery(sql);
//			
//			while(rs.next()) {
//				String screencode = rs.getString("screencode");
//				String moviecode = rs.getString("moviecode");
//				String theatercode = rs.getString("theatercode");
//				String starttime = rs.getString("starttime");
//				String endtime = rs.getString("endtime");
//				int soldseats = rs.getInt("soldseats");
//				
//				DTO_Screen a1 = new DTO_Screen(screencode, moviecode, theatercode, starttime, endtime, soldseats);
//				AddrList.add(a1);
//			}
//			stmt = conn.createStatement();
//			String sql = String.format("SELECT DATE_FORMAT(enddate, '%m%d') FROM screen WHERE screencode = '%s'" , screencode);
//			rs = stmt.executeQuery(sql);
//			String enddate = rs.getString(1);
//			return enddate;
//		}catch (Exception e) {
//			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
//			e.printStackTrace();
//		}
//		return "";
//	}
	public ArrayList<DTO_Screen> test1() {
		ArrayList<DTO_Screen> ScreenList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String testa = String.format("select screen.screencode,movie.moviename,theater.theatername from screen left join movie on screen.moviecode = movie.moviecode left join theater on screen.theatercode = theater.theatercode");
			rs = stmt.executeQuery(testa);
			
			while(rs.next()) {
				String a = rs.getString("screencode");
				String b = rs.getString("moviename");
				String c = rs.getString("theatername");
				
				DTO_Screen s = new DTO_Screen(a, b, c);
				ScreenList.add(s);
			}
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
		return ScreenList;
	}
	
	
}
