package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Attraction.attractionitem;
import data.Festival.festivalitem;
import data.Food.foodItem;
import util.AttractionDetailAPI;
import util.FestivalDetailAPI;
import util.foodDetailAPI;

@WebServlet("/index-task")
public class indexTaskController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<attractionitem> attractionitem = new LinkedList<>();
		int UC_SEQ = Integer.parseInt(req.getParameter("no"));
		attractionitem[] attractionitems = AttractionDetailAPI.getAttractions(UC_SEQ + "").getItem();
		for (int i = 0; i < attractionitems.length; i++) {
			if (attractionitems[i].getUC_SEQ() == UC_SEQ) {
				attractionitem.add(attractionitems[i]);
				if (attractionitem.isEmpty()) {
					req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);
				} else {
					req.setAttribute("item", attractionitem.get(0));
					req.getRequestDispatcher("/WEB-INF/views/attractionDetail.jsp").forward(req, resp);
				}
			}
		}

		List<foodItem> fooditem = new LinkedList<>();
		foodItem[] fooditems = foodDetailAPI.getFood(UC_SEQ + "").getItem();
		for (int i = 0; i < fooditems.length; i++) {
			fooditem.add(fooditems[i]);
		}

		if (fooditem.isEmpty()) {
			req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);
		} else {
			req.setAttribute("thing", fooditem.get(0));
			req.getRequestDispatcher("/WEB-INF/views/foodDetail.jsp").forward(req, resp);
		}

		List<festivalitem> festivalitem = new LinkedList<>();
		festivalitem[] festivalitems = FestivalDetailAPI.getFestivals(UC_SEQ + "").getItem();
		for (int i = 0; i < festivalitems.length; i++) {
			festivalitem.add(festivalitems[i]);
		}

		if (festivalitem.isEmpty()) {
			req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);
		} else {
			req.setAttribute("item", festivalitem.get(0));
			req.getRequestDispatcher("/WEB-INF/views/festivalDetail.jsp").forward(req, resp);
		}

	}
}
