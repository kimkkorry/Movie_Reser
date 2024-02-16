package MovieReservationDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Movie {
	DBConnection a = new DBConnection(); 
	// JDBC 관련 함수
	Connection conn = a.conn;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	// MOVIE 리스트 생성
	public ArrayList<DTO_Movie> getmovie() {
		ArrayList<DTO_Movie> Movies = new ArrayList<>();
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MOVIE;\r\n"+"";
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				String moviecode = rs.getString("moviecode");
				String moviename = rs.getString("moviename");
				String thema = rs.getString("thema");
				int runtime = rs.getInt("runtime");
				int agegroup = rs.getInt("agegroup");
				float salesrate = rs.getFloat("salesrate");
				String opendate = rs.getString("opendate");
				
				DTO_Movie m1 = new DTO_Movie(moviecode, moviename, thema, runtime, agegroup, opendate, salesrate);
				Movies.add(m1);
			}
		} catch (Exception e) {
			System.out.println("list DB 작업중 문제 발생!");
			e.printStackTrace();
		}
		return Movies;	
	}	// getMovie()
	
	public void insertMovie(String moviecode, String moviename, String thema, int runtime, int agegroup, float salesrate, String opendate) {
		try {
			String sql = "INSERT INTO MOVIE (moviecode, moviename, thema, runtime, agegroup, salesrate, opendate) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, moviecode);
			pstmt.setString(2, moviename);
			pstmt.setString(3, thema);
			pstmt.setString(4, Integer.toString(runtime));
			pstmt.setString(5, Integer.toString(agegroup));
			pstmt.setString(6, Float.toString(salesrate));
			pstmt.setString(7, opendate);
			pstmt.executeUpdate();	
	     } catch (Exception e) {
	    	System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
	    	e.printStackTrace();
	     }
	  }	// insertMovie()
	
	public void updateMovie(String moviecode, String moviename, String thema, int runtime, int agegroup, String opendate) {
		try {
			String sql = "UPDATE MOVIE SET moviename = ?, thema = ?, runtime = ?, agegroup = ?, opendate = ? WHERE moviecode = ?"; 
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, moviename);
			pstmt.setString(2, thema);
			pstmt.setString(3, Integer.toString(runtime));
			pstmt.setString(4, Integer.toString(agegroup));
			pstmt.setString(5, opendate);
			pstmt.setString(6, moviecode);
			pstmt.executeUpdate();	
		} catch (Exception e) {
			System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}	// updateMovie()
	
	public void deleteMovie(String moviecode) {
		try {
			String sql = "DELETE FROM MOVIE WHERE moviecode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, moviecode);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}	// deleteMovie()
	
}	// DAO_Movie class