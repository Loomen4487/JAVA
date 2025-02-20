package com.student1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.student1.utlis.DBManager;

public class Board1Service {
	
	Scanner scanner = new Scanner(System.in);
		
		/*
		 * 설명: 게시글 작성
		 */
	public int insertBoard() {
		// 1. 게시글 제목 받기
		System.out.print("글제목(취소: quit): ");
		String title = scanner.nextLine();		//키보드로 '글제목'받기
		if(title.equals("quit")) {
			System.out.println("작성이 취소되었습니다");
			return -1;
		}
		
		
		// 2. 게시글 내용 받기
		System.out.print("글내용: ");
		String content = scanner.nextLine();
		if(title.equals("quit")) {
			System.out.println("작성이 취소되었습니다");
			return -1;
		}
		
		// 3. 위의 입력된 게시글의 제목과 내용을 받아서 Oracle DB에 저장할 수 있도록 DB접속준비
		Connection conn = DBManager.getConnection();
		
		// 4. Oracle DB에 데이터를 삽입하기 위해 insert sql문을 작성
		String insertsql = """
				INSERT INTO board(seq, title, content, read_count) 
				VALUES(seq_board_no.nextval, ?, ?, 0)
		""";
		
		int resultRows = 0;		// insert문을 실행한 뒤에 테이블 영향을 받은 행 개수
		PreparedStatement pstmt = null;;
		
		try { 
			// 5. Oracle DB에 데이터를 삽입 코드를 실행할 준비
			pstmt = conn.prepareStatement(insertsql);
			pstmt.setString(1, title);		// 위 insertsql에 첫번째 ?에 키보드로 입력받은 제목을 세팅
			pstmt.setString(2, content);	// 위 insertsql에 두번째 ?에 키보드로 입력받은 제목을 세팅
		
			// 6. 실제로 sql코드를 실행
			resultRows = pstmt.executeUpdate();		// executeUpdate로 insert, update, delete sql코드를 실행
			
			System.out.println("글 성공적으로 등록됨");
		} catch(SQLException se) {
			System.out.println("게시글 삽입하는 도중 에러가 발생 ->" + se.getMessage());
		} finally {
			// 7. Oracle DB접속 관련 객체들 정리
			DBManager.dbClose(conn, pstmt, null);
		}
		
		return resultRows;
	}
	/*
	 *  설명: 글목록조회
	 */
	
	public void selectAllBoard() {
		// 게시판 목록 조회
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("번호         제목                             작성일           수정일            조회수");
		System.out.println("-------------------------------------------------------------------------------");
		
		// Oracle DB의 Board테이블에서 위의 4가지 항목(번호, 제목, 작성일자, 조회)가 나오도록 출력
		Connection conn = DBManager.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSql = "SELECT seq, title, creat_date, read_count FROM board ORDER BY seq DESC";
		int countRows = 0;	// 행의 번호
		
		try {
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// sql실행한 데이터들의 1행을 가져옴
				countRows++;
				
//				System.out.println(
//					rs.getString("seq") + "          " + rs.getString("title") + "               " + rs.getString("creat_date") + "    " + rs.getString("read_count") 
//				);
				// printf -> %-3s -> '-'는 오른쪽에서부터 공백 문자열 채워줌.
				// printf -> %3s -> 일반숫자는 왼쪽에서부터 공백 문자열 채워줌.
//				System.out.printf(" %-6s   %-30s    %-20s  %5s\n"
//						, rs.getString("seq")
//						, rs.getString("title")
//						, rs.getString("creat_date")
//						, rs.getString("read_count") == null ? "" : rs.getString("read_count")
//					);
				System.out.println(
					String.format("%-10s", rs.getString("seq")) + 
					String.format("%-30s", rs.getString("title")) + 
					String.format("%-15s", rs.getString("creat_date")) + 
					String.format("%-15s", rs.getString("update_date") == null ? "" : rs.getDate("update_date")) +
					String.format("%10s", rs.getString("read_count"))
				);
			}
			if (countRows == 0) {	// board테이블에 데이터가 없을 경우
				System.out.println("게시글이 존재하지 않습니다.");
			}
		} catch(SQLException se) {
			System.out.println("게시글 목록 조회하는 도중 에러가 발생 -> " + se.getMessage());
		} finally {
			// Oracle DB 접속 관련 객체들 정리
			DBManager.dbClose(conn, pstmt, rs);
		}
	}
	/*
	 *  설명: 콘솔에서 사용자의 키보드 입력받은 값을 리턴
	 * @return 게시판 번호
	 */
	private int getBoardNO() {
		int boardNO = 0;
		while(true) {
		System.out.println("게시판 번호를 입력하세요.> ");
		
			try {
				boardNO = Integer.parseInt(scanner.nextLine());
				break;
			}catch(InputMismatchException | NumberFormatException e) {
				System.out.println("잘못된 값을 입력하셨습니다. 다시 입력해주세요.");
			}catch(Exception e) {
				System.out.println("알 수 없는 오류 ->" + e.getMessage());
				}
		}
		
		return boardNO;
	}
	/*
	 *  설명: 게시판 상세 조회
	 */
	public void selectOneBoard() {
		// 게시판 상세 조회
		int boardNO = getBoardNO();
		
		// 1. 게시글의 상세 데이터를 받기 위해 Oracle DB접속준비
		Connection conn = DBManager.getConnection();
		
		String countSql = "SELECT COUNT(*) FROM board WHERE seq = ?";
		
		// 2. 상세조회할 sql코드 작성 및 실행
		//String detailSelectsql = "SELECT * FROM board WHERE seq =" + boardNO;
		String detailSelectsql = "SELECT * FROM board WHERE seq = ?";
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 3. sql 실행
		try {
			pstmt = conn.prepareStatement(countSql);
			pstmt.setInt(1, boardNO);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int rowCount = rs.getInt(1);		// count(*) 값 가져오기
				
				if(rowCount == 0) {			// 상세조회할 게시글이 없는 경우
					System.out.println("상세조회할 게시글 번호가 없습니다.");
					return;
				}
			}
			pstmt = conn.prepareStatement(detailSelectsql);
			pstmt.setInt(1, boardNO);
			rs = pstmt.executeQuery();		// selct실행(detail)
			
			while(rs.next()) {		// sql 실행한 데이터들의 1행을 가져옴(데이터가 있으면 true, 없으면 false)
				// 4. sql실행해서 가져온 데이터들을 자바변수에 세팅 혹은 출력
				// 5. 게시판 상세조회 출력 화면
				System.out.println("-------------------------------------------------------------");
				System.out.println("게시글 번호: " + rs.getInt(1));
				System.out.println("게시글 제목: " + rs.getString(2));
				System.out.println("게시글 내용: " + rs.getString(3));
				System.out.println("게시글 작성일: " + rs.getDate(4));
				System.out.println("-------------------------------------------------------------");
			}
			
			// 조회수 1증가
			String updateQuery = "UODATE biard SET read_count = NVL(read_count, 0) + 1 WHERE seq = ?";
			pstmt = conn.prepareStatement(updateQuery);
			pstmt.setInt(1, boardNO);
			rs = pstmt.executeQuery();	//update 실행
		}catch(SQLException se) {
			System.out.println("게시판 상세조회 쿼리 실행 오류: " + se.getMessage());
		} finally {
			DBManager.dbClose(conn, pstmt, rs);
			}
		
		
		
		}
	
	/*
	 *  설명: 게시글 수정
	 */
	
	public void updateOneBoard() {
		// 1. 수정할 게시글 번호
		int boardNO = getBoardNO();
		
		String countSql = "SELECT COUNT(*) FROM board WHERE seq = ?";
		
		Connection conn = DBManager.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow = 0;
		try {
			// 3. sql실행
			pstmt = conn.prepareStatement(countSql);
			pstmt.setInt(1, boardNO);
			rs = pstmt.executeQuery(); // select실행(count)
			
			if(rs.next()) {
				resultRow = rs.getInt(1);
				if (resultRow == 0) {
					System.out.println("없는 게시판 번호입니다.");
					return;
				}
			}
		} catch(SQLException se) {
			System.out.println("게시판 번호 개수 쿼리 실행 오류: " + se.getMessage());
		}
		// 2. 수정할 게시글 제목
		System.out.println("수정할 게시판 제목를 입력하세요.> ");
		String updateTitle = scanner.nextLine();
		
		// 3. 수정할 게시글 내용
		System.out.println("수정할 게시판 내용를 입력하세요.> ");
		String updatecontent = scanner.nextLine();
		
		// 게시글 특정번호 수정 sql
		String updateOneSql = "UPDATE board SET title = ?, content = ?, update_date = sysdate WHERE seq = ?";
		
				
				// 3. sql 실행
		try {
			pstmt = conn.prepareStatement(updateOneSql);
			pstmt.setString(1, updateTitle);
			pstmt.setString(2, updatecontent);
			pstmt.setInt(3, boardNO);
			resultRow = pstmt.executeUpdate();		// Select 실행
					
			System.out.println("게시글 번호 " + boardNO + "번을 성곡적으로 수정하였습니다.");
		}catch(SQLException se) {
			System.out.println("게시판 수정 쿼리 실행 오류: " + se.getMessage());
		} finally {
			DBManager.dbClose(conn, pstmt, rs);
		}

		
	}
	/*
	 *  설명: 게시글 삭제
	 */
	public void deleteOneBoard() {
		int boardNO = getBoardNO();
		
		System.out.print("정말 " + boardNO + "번 게시글을 삭제하시겠습니까? (Y/N)");
		String confirmYN = scanner.nextLine();
		if (!confirmYN.equals("Y"))
			return;
		
		// 1. 게시글의 상세 데이터를 받기 위해 Oracle DB접속준비
		Connection conn = DBManager.getConnection();
		
		// 입력한 게시글 번호의 개수를 가져오기
		String countSql = "SELECT COUNT(*) FROM board WHERE seq = ?";
		
		// 2. 게시글 특정번호 삭제 sql
		String deletOneSql = "DELETE FROM board WHERE seq = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow = 0;
		
		// 3. sql 실행
		try {
			pstmt = conn.prepareStatement(countSql);
			pstmt.setInt(1, boardNO);
			rs = pstmt.executeQuery();		// Select 실행
			if(rs.next()) {
				resultRow = rs.getInt(1);
				
				if(resultRow == 0) {
					System.out.println("삭제할 게시글 번호가 없습니다.");
					return;
				}
			}
			
			pstmt = conn.prepareStatement(deletOneSql);
			pstmt.setInt(1, boardNO);
			pstmt.executeUpdate();		// Select 실행
			
			System.out.println("게시글 번호 " + boardNO + "번을 성곡적으로 삭제하였습니다.");
		}catch(SQLException se) {
			System.out.println("게시판 삭제 쿼리 실행 오류: " + se.getMessage());
		} finally {
			DBManager.dbClose(conn, pstmt, rs);
		}
		
		
	}
	
	/*
	 * 설명: 게시글 작성
	 */
	public void updateBoard() {
		
	}
}
