package guestbookController;

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

@WebServlet("/guestbook/update-task")
public class UpdateTaskController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		users logonUser = (users) req.getSession().getAttribute("logonUser");
		
		String content = req.getParameter("content");
		String boardId = req.getParameter("boardId");
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("boardId", boardId);
		
		sqlSession.update("messages.updateBoard", map);
		sqlSession.commit();
		sqlSession.close();
		resp.sendRedirect("/guestbook/listDetail?boardId="+boardId);
		
	}

}
