package guestbookController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.guestBook.guestBook;

@WebServlet("/guestbook/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
//		String boardId = req.getParameter("boardId");
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		System.out.println(boardId);
		guestBook guestbook = sqlSession.selectOne("messages.findByBoardId", boardId);
		req.setAttribute("gbook", guestbook);
		
		req.getRequestDispatcher("/WEB-INF/guestbook/update.jsp?boarId" + boardId).forward(req, resp);
	}

}
