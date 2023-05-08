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
import repoistory.GuestbookDAO;


@WebServlet("/guestbook/write-task")
public class WriteTaskController extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();

		users logonUser = (users) req.getSession().getAttribute("logonUser");
		String content = req.getParameter("content");
		String userId = req.getParameter("userId");
		String boardPass = req.getParameter("boardPass");
		String writer = req.getParameter("writer");
		

		if (logonUser == null) {
			if (logonUser == null && boardPass != null && content != null && writer != null) {
				int li =GuestbookDAO.creategusetBook(content,boardPass,writer);
				resp.sendRedirect("/guestbook/list");
				sqlSession.commit();
				sqlSession.close();
			} 
		}else if (logonUser != null && content != null) {
			Map<String, Object> map1 = new HashMap<>();
			map1.put("boardPass", logonUser.getPass());
			map1.put("content", content);
			map1.put("writer", logonUser.getNick());
			map1.put("userId", logonUser.getId());
			int r = sqlSession.insert("messages.createMessage", map1);
			resp.sendRedirect("/guestbook/list");
			sqlSession.commit();
			sqlSession.close();
		}

	}
}
