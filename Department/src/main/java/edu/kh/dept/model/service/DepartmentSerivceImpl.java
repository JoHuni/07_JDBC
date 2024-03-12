package edu.kh.dept.model.service;


//JDBCTemplate 클래스의 static 메서드 모두 가져오기
import static edu.kh.dept.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.dept.model.dao.DepartmentDAO;
import edu.kh.dept.model.dao.DepartmentDAOImpl;
import edu.kh.dept.model.dto.Department;


// Service
// - 비즈니스 로직 처리
// (데이터 가공, 트랜잭션 제어 처리)

// - 트랜잭션 제어 처리
// -> 하나의 Serivce 메서드가 여러 DAO 메서드를 호출할 수 있다!
//		- 호출한 ****모든**** DAO 메서드가 성공했을 때 Commit
//		- 호출한 DAO메서드가 ****하나라도**** 실패하면 Rollback
public class DepartmentSerivceImpl implements DepartmentService{
	private DepartmentDAO dao = new DepartmentDAOImpl();
	
	// 모든 부서 조회
	@Override
	public List<Department> selectAll() throws SQLException {
		
		/* 1. 커넥션 얻어오기 */
		Connection conn = getConnetion();
		
		/* 2. DAO 메서드 호출 (매개 변수로 Connection 전달) */
		List<Department> deptList = dao.selectAll(conn);
		
			
		
		return deptList;
	}
	
}
