package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Users.users;
import data.guestBook.guestBook;

@WebServlet("/user/mypage")
public class MypageController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		users logonUser  = (users) req.getSession().getAttribute("logonUser");
		req.setAttribute("id", logonUser.getId());
		req.setAttribute("pass", logonUser.getPass());
		req.setAttribute("nick", logonUser.getNick());
		
		String userId = logonUser.getId();
		System.out.println(userId);
		
		List<guestBook> gbLists = sqlSession.selectList("messages.findByUserId", userId);
		
		
	    req.setAttribute("guestbook", gbLists);
	    sqlSession.close();
	    
	    req.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp").forward(req, resp);
		
	}

}