package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import data.Users.users;
import repoistory.GuestbookDAO;

@WebServlet("/guestbook-task")
public class GuestBookTaskController extends HttpServlet  {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		users logonUser  = (users) req.getSession().getAttribute("logonUser");	
		String content = req.getParameter("content");
		String userId = req.getParameter("userId");
		
		if (content == null) {
			resp.sendRedirect("/guestbook?cause=error");
			return;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		if (logonUser == null) {
			String boardPass = req.getParameter("boardPass");
			String writer = req.getParameter("writer");
			int r = GuestbookDAO.creategusetBook(content, boardPass, writer);
			if (boardPass == null) {
				resp.sendRedirect("/guestbook?cause=error");
				return;
			}
			map.put("boardPass", boardPass);
			map.put("writer", writer);
			sqlSession.insert("messages.create", map);
		}else {
			String writer = logonUser.getNick();
			map.put("writer", writer);
			sqlSession.insert("messages.create", map);
		}
		
		
		resp.sendRedirect("/guestbook");
	}

}
