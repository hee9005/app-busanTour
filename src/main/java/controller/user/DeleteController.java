package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Users.users;
import data.guestBook.guestBook;

@WebServlet("/user/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		
		users logonUser  = (users) req.getSession().getAttribute("logonUser");
		req.setAttribute("userId", logonUser.getId());
		
	
		
//		int boardId = Integer.parseInt(req.getParameter("boardId"));
//		guestBook guestbook = sqlSession.selectOne("messages.findByBoardId", boardId);
//		req.setAttribute("gbook", guestbook);
		
		req.getRequestDispatcher("/WEB-INF/views/user/delete.jsp").forward(req, resp);
	}

}
