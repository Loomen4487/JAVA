package com.student1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class JavaSqlExample1 {
	public static void main(String[] args) {
		// java와 oracle sql을 연동하는 예제
		
		// 1. java와 oracle을 연동 지원을 해주는 드라이버(oracle회사에서 jar파일로 제공)를 설정해야 함.
		//	(1) ojdbc8~jar파일 프로젝트 내에 저장
		//	(2) java build path - library - class path에 external jars로 (1)의 파일을 등록
		
		// 2. ojdbc의 패키지 라이브러리 클래스 파일 중에 접속 및 연동을 도와주는 클래스 객체를 선언
		//	(1) Connection	-> DBMS 접속 관리 클래스
		//	(2) Statement, PrepareStatement -> SQL 실행을 도와주는 클래스
		//	(3) ResultSet	-> SQL실행 이후 결과 데이터들을 컨드롤하는 클래스
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");				// 오라클 접속을 위한 Driver 사전작업
		
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";	// 오라클 위치값 저장
			String username = "boarduser1";		// 오라클 접속 계정 id
			String password = "1234";			// 오라클 접속 계정 pw
			
			// 실제 오라클 접속을 다루는 객체를 받아서 connection클래스 객체에 대입
			conn = DriverManager.getConnection(url, username, password);	
			
		} catch(Exception e) {
			e.printStackTrace();		// 에러 추적 표시
		
			System.out.println("DB연결 오류");
		}
		
		// 게시글 조회
		//String sql1 = "SELECT seq, title, content, creat_date, read_count FRom board where seq = 2";
		//String sql1 = "SELECT * FROM board";
		//String sql1 = "SELECT seq, title, content, creat_date, read_count FRom board where seq = ? or title = ?";
		String sql1 = "SELECT seq, title, content, creat_date, read_count FRom board "
				+ "where seq = " + 2 + " or title = '" + "제목입니다1" + "'" ;
		try {
			pstmt = conn.prepareStatement(sql1);		// sql1 문자열에 있는 sql문을 실행준비
//			pstmt.setInt(1, 2);					// 첫번쨰 ?에 숫자 2를 세팅			
//			pstmt.setString(2, "제목입니다1");		// 두번째 ?에 문자열'제목입니다1'를 세팅
			rs = pstmt.executeQuery();			// sql1 문자열에 있는 sql문(select문)을 실행
			
			while(rs.next()) {		// rs.next()는 가져온 데이터들의 행을 가져오고 값이 있다면 true를 반환
				// 한꺼번에 주석처리 -> 블록을 지정하고 ctrl + / 하면 됨
				System.out.println("게시글 번호: " + rs.getString("seq"));		// 각 행의 seq 컬럼의 값을 가져온다.
				System.out.println("게시글 제목: " + rs.getString("title"));		// 각 행의 title 컬럼의 값을 가져온다.
				System.out.println("게시글 내용: " + rs.getString("content"));		// 각 행의 content 컬럼의 값을 가져온다.
				System.out.println("게시글 날짜: " + rs.getString("creat_date"));		// 각 행의 creat_date 컬럼의 값을 가져온다.
				System.out.println("게시글 조회수: " + rs.getString("read_count"));		// 각 행의 read_count 컬럼의 값을 가져온다.
				
//				System.out.println("게시글 번호: " + rs.getString(1));		// 각 행의 첫번째컬럼(seq 컬럼)의 값을 가져온다.
//				System.out.println("게시글 제목: " + rs.getString(2));		// 각 행의 두번쨰컬럼(title 컬럼)의 값을 가져온다.
//				System.out.println("게시글 내용: " + rs.getString(3));		// 각 행의 세번째컬럼(content 컬럼)의 값을 가져온다.
//				System.out.println("게시글 날짜: " + rs.getString(4));		// 각 행의 네번째컬럼(creat_date 컬럼)의 값을 가져온다.
//				System.out.println("게시글 조회수: " + rs.getString(5));		// 각 행의 다섯번쨰컬럼(read_count 컬럼_의 값을 가져온다.
//				
//				System.out.println("게시글 번호: " + rs.getInt("seq"));	//	각 행의 첫번쨰 칼럼(seq칼럼)의 값(리턴랎 int)를 가져온다
//				System.out.println("게시글 번호: " + rs.getInt(1));
//				//System.out.println("게시글 번호: " + rs.getInt("title"));	// error-> tile컬럼 데이터 형태는 String이기 때문
//				System.out.println("게시글 번호: " + rs.getInt(5));			// null인 경우에는 기본적으로 0
				
				System.out.println("-----------------------------------");
			}
			
		} catch(SQLException se) {
			se.printStackTrace();
			
			System.out.println("db-sql실행오류");
		}
		
		// DB입출력 자원을 정리
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
		} catch(SQLException se) {
			se.printStackTrace();
		}
	
		System.out.println("javasql 테스트 프로그램 종료");
	}	
	
}
	

