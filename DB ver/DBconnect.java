package TeamC_Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBconnect {

	Connection con = null;
	Statement st = null;
	ResultSet res = null;
	
	String url = "jdbc:mysql://localhost:3306/Tiketing?severTimezone=UTC";
	String user = "root";
	String pw = "1234";
	
	public DBconnect() {
		con = getConnection();
	}
	
	// DB 연결여부를 확인하는 메소드
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, user, pw);
//			System.out.println("ticketing DB 커넥션 성공");
		} catch (Exception e) {
			System.out.println("DB 작업중 문제 발생 : " + e.getMessage());
		}
		return con;
		}
	public void closeTicketing() {
		try { 
			if(con != null) {
				con.close();
			}
			if(st != null) {
				st.close();
			}
			if(res != null) {
				res.close();
			}
			System.out.println("ticketing DB연결을 종료합니다.");
		} catch (SQLException e) {
			System.out.println("DB 종료중 문제발생");
			e.printStackTrace();
		}
	}

	public ArrayList<DTO_Theater> getTheater() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
	

