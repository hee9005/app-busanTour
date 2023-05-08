package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Food.foodItem;
import data.views.views;
import util.foodDetailAPI;

@WebServlet("/food-task")
public class FoodTaskController extends HttpServlet {
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<foodItem> fooditem = new LinkedList<>();
		String UC_SEQ = req.getParameter("no");

		SqlSessionFactory factory =
				(SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		try (SqlSession sqlSession = factory.openSession(true)) {
			 List<views> viewsList = sqlSession.selectList("findView");
	            
	            List<views> viewsLists = sqlSession.selectList("findViews",UC_SEQ);
	            boolean viewExists = false;
	            for (views item : viewsList) {
	                if (item.getTarget().equals(UC_SEQ)) {
	                    viewExists = true;
	                    break;
	                }
	            }
	            if (viewExists) {
	                sqlSession.update("view.updateView", UC_SEQ);
	            } else {
	                sqlSession.insert("view.createView", UC_SEQ);
	            }
				foodItem[] fooditems = foodDetailAPI.getFood(UC_SEQ).getItem();
				for (int i = 0; i < fooditems.length; i++) {
					fooditem.add(fooditems[i]);
				}
				if (fooditem.isEmpty()) {
					req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);
				} else {
					 req.setAttribute("views", viewsLists);
					req.setAttribute("thing", fooditem.get(0));
					req.getRequestDispatcher("/WEB-INF/views/foodDetail.jsp").forward(req, resp);
				}
			} catch (Exception e) {
            throw new ServletException(e);
        }
    }
}

	

