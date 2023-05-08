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

@WebServlet("/user/mypage")
public class MypageController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		users logonUser  = (users) req.getSession().getAttribute("logonUser");
		
	    String userId = logonUser.getId();
		
		guestBook guestbook = sqlSession.selectOne("messages.findByUserId", userId);
		
		
	    req.setAttribute("guestbook", guestbook);
	    sqlSession.close();
	    
	    req.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp").forward(req, resp);
		
	}

}
