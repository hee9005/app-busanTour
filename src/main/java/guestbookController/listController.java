package guestbookController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import data.Users.users;
import data.guestBook.guestBook;

@WebServlet("/guestbook/list")
public class listController extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		users logonUser = (users) req.getSession().getAttribute("logonUser");
		
		Map<String, Object> li = new HashMap<>();
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String writed = req.getParameter("writed");
		li.put("content", content);
		li.put("writer", writer);
		li.put("writed", writed);
		List<guestBook> list = sqlSession.selectList("messages.findAllDesc", li);
		req.setAttribute("list", list);
		
		
		req.getRequestDispatcher("/WEB-INF/guestbook/list.jsp").forward(req, resp);
	}
	
}
