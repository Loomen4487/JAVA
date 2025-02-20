package landutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class LandManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String username = "landuseplan";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
			
			System.out.println("DB 연결 오류");
		}
		return conn;
	}
	public static void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {		// 데이터 가져온 것을 close
				rs.close();
			}
			if(pstmt != null) {		// 데이터 가져온 실행 close
				pstmt.close();
			}
			if(conn != null) {		// 오라클 접속을 close
				conn.close();
			}
		}catch (SQLException se) {
			System.out.println("Oracle DB IO 오류 -> " + se.getMessage());
		}
	}
}
