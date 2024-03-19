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

@WebServlet("/bbs/findId")
public class FindIdServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/findId.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			UserSerivce service = new UserServiceImpl();
		

			String userName = req.getParameter("userName");
			String phoneNumber = req.getParameter("phoneNumber");
			BBSUser user = service.findUserId(userName, phoneNumber);
			
			String message = null;
			HttpSession session = req.getSession();
			
			String path = "/WEB-INF/views/findIdResult.jsp";

			if(user == null) {
				message = "일치하는 정보가 없습니다.";
				session.setAttribute("message", message);
				path = "/WEB-INF/views/findId.jsp";
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
