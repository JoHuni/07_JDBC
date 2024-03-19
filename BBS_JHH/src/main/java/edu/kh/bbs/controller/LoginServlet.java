package edu.kh.bbs.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.bbs.model.dto.BBSUser;
import edu.kh.bbs.model.service.UserSerivce;
import edu.kh.bbs.model.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bbs/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/login.jsp";
        req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserSerivce service = new UserServiceImpl();
			
			String userId = req.getParameter("userId");
			String userPw = req.getParameter("userPw");
			
			BBSUser user = service.loginUser(userId, userPw);	
			String path = "/WEB-INF/views/login.jsp";

            if (user != null) {
                req.getSession().setAttribute("loginUser", user);
                req.getSession().setAttribute("message", "로그인 성공!");
                resp.sendRedirect("/");
            }
            else {
                req.getSession().setAttribute("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
                req.getRequestDispatcher(path).forward(req, resp);
            }
        }
		catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
