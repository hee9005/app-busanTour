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
import util.AttractionAPI2;
import util.festivalAPI2;
import util.foodAPI2;


@WebServlet("/index-task")
public class indexTaskController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int p;
		if (req.getParameter("page") == null) {
			p = 1;
		} else {
			p = Integer.parseInt(req.getParameter("page"));
		}
		String pageNo;
		if(req.getParameter("page") ==null) {
			pageNo ="1";
		}else {
			pageNo=req.getParameter("page");
		}
		List<attractionitem> attractionitem = new LinkedList<>();
		int UC_SEQ = Integer.parseInt(req.getParameter("no"));
		
		attractionitem[] attractionitems = AttractionAPI2.getAttractions(pageNo).getItem();

		for (int i = 0; i < attractionitems.length; i++) {
			if (attractionitems[i].getUC_SEQ() == UC_SEQ) {
				attractionitem.add(attractionitems[i]);
				req.setAttribute("item", attractionitem.get(0));
				req.getRequestDispatcher("/WEB-INF/views/attractionDetail.jsp").forward(req, resp);
				System.out.println("forward");
				break;
			}
		}

		List<festivalitem> festivalitem = new LinkedList<>();
		festivalitem[] festivalitems = festivalAPI2.getFestivals(pageNo).getItem();
		for (int j = 0; j < festivalitems.length; j++) {
			if (festivalitems[j].getUC_SEQ() == UC_SEQ) {
				festivalitem.add(festivalitems[j]);
				req.setAttribute("item", festivalitem.get(0));
				req.getRequestDispatcher("/WEB-INF/views/festivalDetail.jsp").forward(req, resp);
				System.out.println("forward");
				break;
			}
		}

		List<foodItem> fooditem = new LinkedList<>();
		foodItem[] fooditems = foodAPI2.getFoods(pageNo).getItem();
		for (int x = 0; x < fooditems.length; x++) {
			if (fooditems[x].getUC_SEQ() == UC_SEQ) {
				fooditem.add(fooditems[x]);
				req.setAttribute("thing", fooditem.get(0));
				req.getRequestDispatcher("/WEB-INF/views/foodDetail.jsp").forward(req, resp);
				System.out.println("forward");
				break;
			}
		}
	}
}