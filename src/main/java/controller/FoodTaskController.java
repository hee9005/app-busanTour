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
import util.foodDetailAPI;


@WebServlet("/food-task")
public class FoodTaskController extends HttpServlet {
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<foodItem> fooditem = new LinkedList<>();
		String UC_SEQ = req.getParameter("no");
		foodItem[] fooditems = foodDetailAPI.getAttractions(UC_SEQ).getItem();
		for (int i = 0; i < fooditems.length; i++) {
			fooditem.add(fooditems[i]);
		}
		if (fooditem.isEmpty()) {
			req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);
		} else {
			req.setAttribute("thing", fooditem.get(0));
			req.getRequestDispatcher("/WEB-INF/views/foodDetail.jsp").forward(req, resp);
		}
	}

}

