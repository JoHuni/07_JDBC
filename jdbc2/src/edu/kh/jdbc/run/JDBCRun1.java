package edu.kh.jdbc.run;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import edu.kh.jdbc.common.JDBCTemplate;

public class JDBCRun1 {
	public static void main(String[] args) {
		// 부서코드를 입력 받아
		// 일치하는 부서명을 수정
		/* 1. JDBC 객체 참조 변수 선언 */
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			/* 2.Connection 객체 얻어오기 */
			conn = JDBCTemplate.getConnetion();
			
			/* 3. SQL 작성 */
			Scanner sc = new Scanner(System.in);
			
			System.out.println("수정할 부서 코드 : ");
			String deptCode = sc.next();
			
			System.out.println("수정할 부서명 : ");
			String deptTitle = sc.next();
			
			String sql = "UPDATE DEPARTMENT4 SET DEPT_TITLE = ? WHERE DEPT_ID = ?";
			
			/* 4. PreparedStatement 객체 생성 + SQL 적재 */
			pstmt = conn.prepareStatement(sql);
			
			/* 5. placeholder에 알맞은 값 세팅 */
			pstmt.setString(1, deptTitle);
			pstmt.setString(2, deptCode);
			
			/* 6. SQL 실행 후 결과 반환 받기 */
			int result = pstmt.executeUpdate();
			
			/* 7. SQL 수행 결과에 따라서 트랜잭션 제어 */
			if(result > 0) {
				System.out.println("수정 성공");
				JDBCTemplate.commit(conn);
			}
			else {
				System.out.println("부서코드가 일치하는 부서가 없습니다");
				JDBCTemplate.rollback(conn);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(conn);
		}
	}
}
