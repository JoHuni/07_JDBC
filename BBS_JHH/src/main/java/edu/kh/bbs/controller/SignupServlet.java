package edu.kh.bbs.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import edu.kh.bbs.model.dto.BBSUser;
import edu.kh.bbs.model.service.UserSerivce;
import edu.kh.bbs.model.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bbs/signup")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/signup.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserSerivce service = new UserServiceImpl();

			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			String userName = req.getParameter("userName");
			String phoneNumber = req.getParameter("phoneNumber");
			
			BBSUser user = new BBSUser(userId, userPw, userName, phoneNumber);
			
			int result = service.signupUser(user);
			
			String message = null;
			
			HttpSession session = req.getSession();
			
			if(result > 0) {
				message = "회원 가입 성공!";
			}
			
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
		}
		catch (SQLIntegrityConstraintViolationException e) {
			String path = "/WEB-INF/views/signup.jsp";
			
		    String message = "이미 사용중인 아이디입니다.";
		    req.getSession().setAttribute("message", message);
		    req.getRequestDispatcher(path).forward(req, resp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
