package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Attraction.attractionitem;
import data.Festival.festivalitem;
import data.Food.foodItem;
import util.AttractionAPI;
import util.festivalAPI;
import util.foodAPI;




 
@WebServlet("/index")
public class indexController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		attractionitem[] attractionitems = AttractionAPI.getAttractions().getItem();
		List<attractionitem> att = new LinkedList<>();
		
		if (attractionitems != null) {
			req.setAttribute("attractions", att);
		}
		
		festivalitem[] festivalitems = festivalAPI.getFestivals().getItem();
		List<festivalitem> fes = new LinkedList<>();
		for (int i = 0; i < festivalitems.length; i++) {
			fes.add(festivalitems[i]);
		}

		

		if (festivalitems != null) {
			req.setAttribute("festivals", fes);
		}
		
		foodItem[] fooditems = foodAPI.getFoods().getItem();
		List<foodItem> foo = new LinkedList<>();
		for (int i = 0; i < fooditems.length; i++) {
			foo.add(fooditems[i]);
		}

		

		if (fooditems != null) {
			req.setAttribute("foods", foo);
		}

		req.getRequestDispatcher("/WEB-INF/index/index.jsp").forward(req, resp);
	}
}

