package edu.kh.dept.controller;

import java.io.IOException;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.service.DepartmentSerivceImpl;
import edu.kh.dept.model.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/department/delete")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 서비스 객체 생성
			DepartmentService service = new DepartmentSerivceImpl();
			
			// 제출된 파라미터
			String deptId = req.getParameter("deptId"); // 삭제할 부서 코드
			
			// 서비스 메서드 호출 후 결과 반환 받기
			int result = service.deleteDepartment(deptId); 
			
			// 서비스 결과에 따라서
			// Session에 "삭제 성공", "삭제 실패" 메시지 속성을 추가
			HttpSession session = req.getSession();
			
			String message = null;
			
			if(result > 0) {
				message = "삭제 성공";
			}
			else {
				message = "삭제 실패";
			}
			
			// 전체 부서 조회를 재요청
			session.setAttribute("message", message);

			resp.sendRedirect("selectAll");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
