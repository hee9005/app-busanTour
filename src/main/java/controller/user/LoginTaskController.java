package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Users.users;

@WebServlet("/user/login-task")
public class LoginTaskController extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
	SqlSession sqlSession = factory.openSession();
	
	String id = req.getParameter("id");
	String pass = req.getParameter("pass");
	users user = sqlSession.selectOne("user.findById", id);
	
	if (user == null) {
		resp.sendRedirect("/user/login?cause=error1");
	}else {
		if (user.getPass().equals(pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("logon", true);
			session.setAttribute("logonUser", user);
			
			resp.sendRedirect("/index");
		}else {
			resp.sendRedirect("/user/login?cause=error");
		}
	}
	sqlSession.commit();
	sqlSession.close();
	
}
}
