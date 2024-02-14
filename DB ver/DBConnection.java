package TeamC_Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	
	// JDBC 관련 함수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 데이터베이스 연결 정보
	private static final String url = "jdbc:mysql://localhost:3306/tiketing";
	private static final String user = "root";
	private static final String pass = "1234";
	
	// 생성자
	public DBConnection() {
		conn = getConnection();
	}
	
	// 드라이버 세팅 및 Connection 획득
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
//			System.out.println("DB Connection 성공");
		} catch (Exception e) {
			System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
		}
		return conn;
	}	// getConnection()package Movie_Admin;

}
