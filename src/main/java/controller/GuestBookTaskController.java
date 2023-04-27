package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import repoistory.GuestbookDAO;

@WebServlet("/guestbook-task")
public class GuestBookTaskController extends HttpServlet  {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		
		String boardId = req.getParameter("boardId");
		String boardPass = req.getParameter("boardPass");
		String content =req.getParameter("content");
		String writer = req.getParameter("writer");
		
		int r = GuestbookDAO.creategusetBook(boardId, content, boardPass, writer);
		resp.sendRedirect("/guesetbook");
	}

}
