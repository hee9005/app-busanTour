package controller.user;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Users.users;

@WebServlet("/user/join-task")
public class joinTaskController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InputStream in = Resources.class.getResourceAsStream("mybatis/config.xml");
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();

		req.setCharacterEncoding("utf-8");

		String id = req.getParameter("id");
		String pass = req.getParameter("password");
		String nick = req.getParameter("nick");
		if (id == null || pass == null || nick == null) {
			resp.sendRedirect("/user/join?cause=error2");
			return;
		}
		users user = sqlSession.selectOne("user.findById", id);
		if(user.getId().equals(id)) {
			resp.sendRedirect("/user/join?cause=error3");
			return;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pass", pass);
		map.put("nick", nick);
		sqlSession.insert("user.create", map);

		sqlSession.commit();
		sqlSession.close();

		resp.sendRedirect("/user/login");
	}	

}