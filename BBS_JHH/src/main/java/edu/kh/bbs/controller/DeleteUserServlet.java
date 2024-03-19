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
import jakarta.websocket.Session;

@WebServlet("/bbs/delete")
public class DeleteUserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserSerivce service = new UserServiceImpl();
			
			BBSUser loginUser = (BBSUser) req.getSession().getAttribute("loginUser");
						
			int result = service.deleteUser(loginUser);	
			
			if(result > 0) {
				req.setAttribute("message", "탈퇴 완료되었습니다!");
				String path = "/";
				resp.sendRedirect(path);
				req.getSession().invalidate();
			}
			else {
				String path = "/WEB-INF/views/update.jsp";

				req.setAttribute("message", "왜안됨?");
				req.getRequestDispatcher(path).forward(req, resp);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
