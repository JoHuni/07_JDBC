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
import jakarta.servlet.http.HttpSession;

@WebServlet("/bbs/findPw")
public class FindPasswordServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/findPw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			UserSerivce service = new UserServiceImpl();
		

			String userId = req.getParameter("userId");
			
			BBSUser user = service.findUserPw(userId);

			
			String message = null;
			HttpSession session = req.getSession();
			
			String path = "/WEB-INF/views/findPwResult.jsp";

			if(user == null) {
				message = "일치하는 아이디가 없습니다.";
				session.setAttribute("message", message);
				path = "/WEB-INF/views/findPw.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
			else {
				session.setAttribute("user", user);
				req.getRequestDispatcher(path).forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}