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

@WebServlet("/mypage/update")
public class MypageUpdateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		users logonUser  = (users) req.getSession().getAttribute("logonUser");
		
		String userId = logonUser.getId();
		System.out.println(userId);
		users user = sqlSession.selectOne("user.findById", userId);
		req.setAttribute("user", user);
		sqlSession.close();
		
		req.getRequestDispatcher("/WEB-INF/views/user/mypageupdate.jsp").forward(req, resp);
	}

}
