package guestbookController;

import java.io.IOException;
import java.util.ArrayList;
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
		

		int p;
		if (req.getParameter("page") == null) {
			p = 1;
		}else {
			p = Integer.parseInt(req.getParameter("page"));
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("a", p*10-9);
		map.put("b", p*10);
		List<guestBook> list = new ArrayList<>();
		
		String arr = req.getParameter("arr");
		if (arr == null) {
			list = sqlSession.selectList("messages.findAllDesc", map);
			req.setAttribute("abc", "basic");
			req.setAttribute("list", list);
		} else {
			if (arr.equals("writed")) {
				list = sqlSession.selectList("messages.findAll", map);
				req.setAttribute("abc", "writed");
				req.setAttribute("list", list);
			}else if (arr.equals("basic")) {
				list = sqlSession.selectList("messages.findAllDesc", map);
				req.setAttribute("abc", "basic");
				req.setAttribute("list", list);
			} 
		}
		
		int total = sqlSession.selectOne("messages.countBoards");
		int lastPage = total / 10 + (total % 10 > 0 ? 1 : 0);
		int last = (int) Math.ceil(p / 5.0) * 5;
		int start = last -4;
		
		last = last > lastPage ? lastPage : last;
		
		req.setAttribute("start", start); 
		req.setAttribute("last", last); 
		
		boolean existPrev = p >=6;
		boolean existNext = lastPage > last;
		req.setAttribute("existPrev", existPrev);
		req.setAttribute("existNext", existNext);
		
		sqlSession.close();
		
//		Map<String, Object> li = new HashMap<>();
//		String content = req.getParameter("content");
//		String writer = req.getParameter("writer");
//		String writed = req.getParameter("wited");
//		li.put("content", content);
//		li.put("writer", writer);
//		li.put("writed", writed);
//		List<guestBook> list = sqlSession.selectList("messages.findAllDesc", li);
//		req.setAttribute("list", list);
//		
		
		req.getRequestDispatcher("/WEB-INF/guestbook/list.jsp").forward(req, resp);
	}
	
}
