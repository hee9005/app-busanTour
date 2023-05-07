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

@WebServlet("/guestbook/passcheck")
public class passcheckController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		String caseCheck = req.getParameter("caseCheck");
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		String pass = req.getParameter("pass");
		
		guestBook guestbook = sqlSession.selectOne("messages.findByBoardId",boardId);
		if(pass.equals(guestbook.getBoardPass())) {
			if(caseCheck.equals("1")) {
				req.setAttribute("gbook", guestbook);
				req.getRequestDispatcher("/WEB-INF/guestbook/update.jsp").forward(req, resp);
			}else if(caseCheck.equals("2")) {
				req.getRequestDispatcher("/WEB-INF/guestbook/delete.jsp").forward(req, resp);
			}
		}else {
			resp.sendRedirect("/guestbook/check?cause=error&boardId="+boardId+"&caseCheck="+caseCheck);
		}
		
	
	
	}

}
