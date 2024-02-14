package TeamC_Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Moviecenter {
	DBConnection a = new DBConnection();	
	Connection conn = a.conn;
//	Connection conn = new DBConnection().conn; // 위 두줄 줄임 코드(현 DBConnection클래스에서만 가능)
	Statement stmt = null;
	ResultSet rs = null;

	public ArrayList<DTO_Moviecenter> getMoviecenter() {
		ArrayList<DTO_Moviecenter> AddrList = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM MOVIECENTER ORDER BY centercode desc;\r\n"+"";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String centercode = rs.getString("centercode");
				String centername = rs.getString("centername");
				String address = rs.getString("address");
				DTO_Moviecenter a1 = new DTO_Moviecenter(centercode, centername, address);
				AddrList.add(a1);
			}
		} catch (Exception e) {
			System.out.println("list DB 작업중 문제 발생!");
			e.printStackTrace();
		}
	
		return AddrList;
	}
	public void insertMoviecenter(String centercode, String centername, String address) {
		try {
			stmt = conn.createStatement();
			String sql = String.format(
					"INSERT INTO MOVIECENTER(centercode, centername, address) VALUES ('%s','%s','%s')", centercode,
					centername, address);
			stmt.executeUpdate(sql);
			System.out.printf("\n[%s] 지점 등록이 완료되었습니다.\n", centername);
		} catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void updateMoviecenter(String centercode, String centername, String address) {
		try {
			stmt = conn.createStatement();
			String sql = String.format(
					"UPDATE MOVIECENTER SET centername = '%s', address = '%s' WHERE centercode = '%s'", centername,
					address, centercode);
			stmt.executeUpdate(sql);
			System.out.printf("[%s] 지점 정보 수정이 완료되었습니다.\n", centername);
		} catch (Exception e) {
			System.out.println("DB 작업 중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}
	public void deleteMoviecenter(String centercode, String centername) {
		try {
			stmt = conn.createStatement();
			String sql = String.format("DELETE FROM MOVIECENTER WHERE centercode = '%s'",centercode);
			stmt.executeUpdate(sql);
			System.out.printf("[%s] 지점 삭제가 완료되었습니다.\n", centername);
		}catch (Exception e) {
			System.out.println("DB 작업중 문제 발생: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
