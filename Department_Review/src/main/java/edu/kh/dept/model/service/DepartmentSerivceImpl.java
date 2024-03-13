package edu.kh.dept.model.service;


//JDBCTemplate 클래스의 static 메서드 모두 가져오기
import static edu.kh.dept.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.dept.model.dao.DepartmentDAO;
import edu.kh.dept.model.dao.DepartmentDAOImpl;
import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.exception.DepartmentInsertException;


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

	// 부서 추가 서비스
	@Override
	public int insertDepartment(Department dept) throws DepartmentInsertException {
		int result = 0;
		
		/* 1. 커넥션 얻어오기 */
		Connection conn = getConnetion();
		try {
			// 2. DAO 메서드 호출 후 결과 반환 바기
			// (DAO 메서드 수행 시 커넥션이 필요하기 떄문에 매개변수로 전달)
			result = dao.insertDepartment(conn, dept);

			// 3. DAO 수행 결과에 따라 트랜잭션 제어 처리
			if(result < 0) {
				rollback(conn);
			}
			else {
				commit(conn);
			}
			
		}
		catch(SQLException e) {
			// PK 제약조건 위배/NOT NULL 제약 조건 위배
			e.printStackTrace();
			
			// 예외 발생 시 무조건 rollback()
			rollback(conn);
			
			/* 제약조건 위배로 인해서 정상 수행 되지 않음을 표현하기 위해
			 * 강제로 예외 발생 - 사용자 정의 예외 이용 */
			
			throw new DepartmentInsertException();
		}
		finally { // 예외 발생 여부 관계 없이 무조건 커넥션 close			
			close(conn);
		}
		
		return result;

	}
}
