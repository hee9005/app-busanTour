
package controller.user;

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


@WebServlet("/user/mypage-detail")
public class MypageDetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		users logonUser  = (users) req.getSession().getAttribute("logonUser");	
		
		if(logonUser == null) {
			resp.sendRedirect("/guestbook/index");
			return;
		}
		req.setAttribute("logonUser", logonUser);
		
		
	
		
	}

}

