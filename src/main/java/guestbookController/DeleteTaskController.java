package guestbookController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



@WebServlet("/guestbook/delete-task")
public class DeleteTaskController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
//      String boardId = req.getParameter("boardId");
		int boardId = Integer.parseInt(req.getParameter("boardId"));
       
		sqlSession.delete("messages.deleteBoard", boardId);

   
		sqlSession.commit();
		sqlSession.close();
		resp.sendRedirect("/guestbook/list");
	
	}
		
}
