package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Food.foodItem;
import util.foodAPI;

@WebServlet("/food")
public class FoodController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		foodItem[] fooditems = foodAPI.getFoods().getItem();
		List<foodItem> foo = new LinkedList<>();
		for (int i = 0; i < fooditems.length; i++) {
			foo.add(fooditems[i]);
		}

		

		if (fooditems != null) {
			req.setAttribute("foods", foo);
		}

		req.getRequestDispatcher("/WEB-INF/index/foodScreen.jsp").forward(req, resp);
	}
	
	

}
