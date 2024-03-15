package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoService;
import edu.kh.todoList.model.service.TodoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/detail")
public class TodoDetailServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			TodoService service = new TodoServiceImpl();
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			Todo todo = service.selectTodo(todoNo);
			
			if(todo != null) {
				req.setAttribute("todo", todo);
				String path = "/WEB-INF/views/detail.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
			}
			else {
				// 파라미터로 전달 받은 todoNo가 DB에 존재하지 않음
				req.getSession().setAttribute("message", "해당 할 일이 존재하지 않습니다");
				resp.sendRedirect("/");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}	
