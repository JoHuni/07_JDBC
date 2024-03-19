package edu.kh.bbs.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.bbs.model.dto.BBS;
import edu.kh.bbs.model.service.BbsService;
import edu.kh.bbs.model.service.BbsServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("")
public class MainServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BbsService service = new BbsServiceImpl();
		
		Map<String, Object> map;
		try {
			map = service.selectAll();
			
			List<BBS> BBSList = (List<BBS>)map.get("BBSList");
			int boardNo	  = (int)map.get("boardNo");
			
			req.setAttribute("BBSList", BBSList);
			req.setAttribute("boardNo", boardNo);
			
			String path = "/WEB-INF/views/index.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
