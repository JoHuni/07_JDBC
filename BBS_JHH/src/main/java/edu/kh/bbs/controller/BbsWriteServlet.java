package edu.kh.bbs.controller;

import java.io.IOException;
import java.sql.SQLException;

import edu.kh.bbs.model.dto.BBS;
import edu.kh.bbs.model.dto.BBSUser;
import edu.kh.bbs.model.service.BbsService;
import edu.kh.bbs.model.service.BbsServiceImpl;
import edu.kh.bbs.model.service.UserSerivce;
import edu.kh.bbs.model.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bbs/write")
public class BbsWriteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/write.jsp";
		
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			BbsService service = new BbsServiceImpl();
			

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			HttpSession session = req.getSession();
			BBSUser loginUser = (BBSUser)session.getAttribute("loginUser");
			String writer = loginUser.getUserId();
			
			BBS bbs = new BBS(title, content, writer);
			
			int result = service.postBoard(bbs);
			
			if(result > 0) {
				req.setAttribute("title", title);
				req.setAttribute("content", content);
				req.setAttribute("writer", writer);
				session.setAttribute("message", "게시글이 등록되었습니다.");
				String path = "/";
				resp.sendRedirect(path);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
}
