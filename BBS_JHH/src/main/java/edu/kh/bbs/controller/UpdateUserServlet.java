package edu.kh.bbs.controller;

import java.io.IOException;
import java.sql.SQLException;

import edu.kh.bbs.model.dto.BBSUser;
import edu.kh.bbs.model.service.UserSerivce;
import edu.kh.bbs.model.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/bbs/update")
public class UpdateUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/update.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserSerivce service = new UserServiceImpl();
		try {
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			String userName = req.getParameter("userName");
			String phoneNumber = req.getParameter("phoneNumber");
			
			BBSUser user = new BBSUser(userId, userPw, userName, phoneNumber);
			int result = service.updateUser(user);
			String path = "/WEB-INF/views/update.jsp";
			
			String message = null;

			if(result > 0) {
				req.getSession().setAttribute("message", "정보 수정 완료!");
				req.getSession().setAttribute("loginUser", user);
				
				path = "/";
				resp.sendRedirect(path);
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
