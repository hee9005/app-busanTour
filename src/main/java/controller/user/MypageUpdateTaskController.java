package controller.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Users.users;

@WebServlet("/mypage/update-task")
public class MypageUpdateTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		//HttpSession session = req.getSession();
		//users user = (users)session.getAttribute("logonUser");
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String nick = req.getParameter("nick");
		System.out.println(id);
		System.out.println(pass);
		System.out.println(nick);
		

		Map<String, Object> map = new HashMap<>();
		map.put("pass", pass);
		map.put("nick", nick);
		map.put("userId", id);
		
		
		sqlSession.update("user.updatePass", map);
		sqlSession.commit();
		sqlSession.close();
		
		resp.sendRedirect("/mypage");	
		
	}

}
