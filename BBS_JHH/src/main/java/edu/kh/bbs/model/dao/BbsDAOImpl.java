package edu.kh.bbs.model.dao;

import static edu.kh.bbs.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.bbs.model.dto.BBS;
import edu.kh.bbs.model.dto.BBSUser;


public class BbsDAOImpl implements BbsDAO{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Statement stmt;
	private Properties prop;
	
	public BbsDAOImpl() {
		try {
			prop = new Properties();
		    String path = UserDAOImpl.class.getResource("/edu/kh/bbs/sql/sql.xml").getPath(); 
		    
		    prop.loadFromXML(new FileInputStream(path));

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	@Override
	public int postBoard(Connection conn, BBS bbs) throws SQLException {
		int result = 0;
		try {
			String sql = prop.getProperty("postBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getContent());
			pstmt.setString(3, bbs.getWriter());
			
			result = pstmt.executeUpdate();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	
	@Override
	public List<BBS> selectAll(Connection conn) throws SQLException {
		
		// 결과 저장용 변수 선언 / 객체 생성
		List<BBS> BBSList = new ArrayList<BBS>();
		
		try {
			String sql = prop.getProperty("selectAllBBS");

			stmt = conn.createStatement();
			
			// SQL 수행 후 결과 반환 받기
			rs = stmt.executeQuery(sql);
			
			// 조회 결과 한 행씩 접근
			while(rs.next()) {
				int 	 boardNo 		= rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String boardContent 	= rs.getString("BOARD_CONTENT");
				String boardWriter 		= rs.getString("BOARD_WRITER");
				
				// Todo객체를 생성해서 값 세팅 후 todoList에 추가
				BBS bbs = new BBS(boardNo, boardTitle, boardContent, boardWriter);
				BBSList.add(bbs);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return BBSList;
	}
	
	// 완료된 할 일 개수 조회
	@Override
	public int getboardNo(Connection conn) throws SQLException {
	
		int boardNo = 0;
		
		try {
			String sql = prop.getProperty("getboardNo");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			// -> GROUP BY가 없는 SELECT의 COUNT 그룹 함수의 결과는 1행!
			// -> if문을 이용해서 조회 결과 행 접근
			
			if(rs.next()) {
				boardNo = rs.getInt(1); // 1번 컬럼 값 
			}
			
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return boardNo;
	}
	
	@Override
	public int deleteBbs(Connection conn, String boardNo) throws SQLException {
		int result = 0;
		try {
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNo);
			
			result = pstmt.executeUpdate();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	@Override
	public int deleteBbs(Connection conn, BBS bbs) throws SQLException {
		int result = 0;
		try {
			String sql = prop.getProperty("updateBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bbs.getTitle());
			pstmt.setString(2, bbs.getContent());
			pstmt.setString(3, bbs.getWriter());
			pstmt.setInt(4, bbs.getBoardNo());
			
			result = pstmt.executeUpdate();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
