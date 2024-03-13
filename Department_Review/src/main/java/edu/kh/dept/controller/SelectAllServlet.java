package edu.kh.dept.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import edu.kh.dept.common.JDBCTemplate;
import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.service.DepartmentSerivceImpl;
import edu.kh.dept.model.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet : 현재 클래스를 서블릿으로 등록 (서버 실행 시 객체 생성) + URL 매핑
@WebServlet("/department/selectAll")
public class SelectAllServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
