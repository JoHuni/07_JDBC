package edu.kh.dept.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.service.DepartmentSerivceImpl;
import edu.kh.dept.model.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/department/search")
public class SeacrhServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			DepartmentService service = new DepartmentSerivceImpl();
			
			String keyword = req.getParameter("keyword");
			
			List<Department> deptList = service.searchDepartment(keyword);
			
			req.setAttribute("deptList", deptList);
			
			// forward할 jsp 경로
			String path = "/WEB-INF/views/search.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
