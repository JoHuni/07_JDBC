package edu.kh.bbs.controller;

import java.io.IOException;
import java.sql.SQLException;

import edu.kh.bbs.model.dto.BBS;
import edu.kh.bbs.model.dto.BBSUser;
import edu.kh.bbs.model.service.BbsService;
import edu.kh.bbs.model.service.BbsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bbs/deleteBbs")
public class DeleteBbsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BbsService service = new BbsServiceImpl();
		
		try {
			HttpSession session = req.getSession();
			String boardNo = req.getParameter("boardNo");
			
			int result = service.deleteBbs(boardNo);
			
			
			if(result > 0) {
				session.setAttribute("message", "삭제되었습니다");
				String path = "/";
				resp.sendRedirect(path);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
