package edu.kh.dept.model.dao;

import static edu.kh.dept.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.dept.common.JDBCTemplate;
import edu.kh.dept.model.dto.Department;

public class DepartmentDAOImpl implements DepartmentDAO {
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop; //Map<String, String> 형태, 파일 입출력 쉬움
	
	// 기본 생성자
	public DepartmentDAOImpl() {
		try {
			prop = new Properties();
		    String path = DepartmentDAOImpl.class.getResource("/edu/kh/dept/sql/sql.xml").getPath(); 
		    
		    prop.loadFromXML(new FileInputStream(path));

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Department> selectAll(Connection conn) throws SQLException {
		// 결과 저장용 변수 선언 / 객체 생성
		List<Department> deptList = new ArrayList<Department>();
		try {
			// SQL 작성
			String sql = prop.getProperty("selectAll");
			
			// Statement 객체 생성
			stmt = conn.createStatement();
			
			// SQL 수행 후 결과 (ResultSet) 반환 받기
			rs = stmt.executeQuery(sql);
			
			// ResultSet 한 행씩 접근해서 컬럼 값을 얻어온 후
			// deptList에다가 옮겨 담기
			while(rs.next()) {
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");
				
				Department dept = new Department(deptId, deptTitle, locationId);
				
				deptList.add(dept);
			}
		}
		finally {
			close(rs);
			close(stmt);
		}
		return deptList;
	}

	@Override
	public int insertDepartment(Connection conn, Department dept) throws SQLException {
		// 1. 결과 저장용 변수 선언 / 객체 생성
		int result = 0;
		try {
			// 2.결과 얻어오기
			String sql = prop.getProperty("insertDepartment");
			
			// 3. PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4. ?에 알맞은 값 대입
			pstmt.setString(1, dept.getDeptId());
			pstmt.setString(2, dept.getDeptTitle());
			pstmt.setString(3, dept.getLocationId());
			
			// 5. SQL 수행 후 결과 반환 받기
			result = pstmt.executeUpdate();
		}
		finally {
			// 6. 사용한 JDBC 객체 반환(단, 커넥션 제외)
			close(pstmt);
		}
		
		return result;
	}

	@Override
	public int deleteDepartment(Connection conn, String deptId) throws SQLException {
		int result = 0;
		try {
			String sql = prop.getProperty("deleteDepartment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptId);
			
			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	@Override
	public Department selectOne(Connection conn, String deptId) throws SQLException {
		Department dept = null;
		try {
			// sql 얻어오기
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptId);
			
			//SQL(SELECT) 수행 후 결과 (ResultSet) 반환 받기
			rs = pstmt.executeQuery();
			
			// PK 조건으로 삼은 SELECT 문은
			// 조회 성공 시 1행만 조회됨 --> if로 해도 ㄱㅊ
			
			if(rs.next()) {
				dept = new Department(rs.getString("DEPT_ID"),
						rs.getString("DEPT_TITLE"),
						rs.getString("LOCATION_ID"));
			}
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return dept;
	}
	
	@Override
	public int updateDepartment(Connection conn, Department dept) throws SQLException {
		int result = 0;
		try {
			String sql = prop.getProperty("updateDepartment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dept.getDeptTitle());
			pstmt.setString(2, dept.getLocationId());
			pstmt.setString(3, dept.getDeptId());
			
			result = pstmt.executeUpdate();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	@Override
	public List<Department> searchDepartment(Connection conn, String keyword) throws SQLException {
		List<Department> deptList = new ArrayList<Department>();
		try {
			String sql = prop.getProperty("searchDepartment");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			

			rs = pstmt.executeQuery();

			while(rs.next()) {
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");
				
				Department dept = new Department(deptId, deptTitle, locationId);
				
				deptList.add(dept);
			}
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return deptList;
	}
}
