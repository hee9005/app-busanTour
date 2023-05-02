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
import util.AttractionAPI;
import util.festivalAPI;
import util.foodAPI;




 
@WebServlet("/index")
public class indexController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		int p;
		if(req.getParameter("page") == null) {
			p=1;
		}else {
			p=Integer.parseInt(req.getParameter("page"));
		}
		String pageNo;
		if(req.getParameter("pageNo") ==null) {
			pageNo ="1";
		}else {
			pageNo=req.getParameter("pageNo");
		}
		attractionitem[] attractionitems = AttractionAPI.getAttractions(pageNo).getItem();
		List<Object> mainHome = new LinkedList<>();
		for (int i = 0; i < attractionitems.length; i++) {
			mainHome.add(attractionitems[i]);
		}

		festivalitem[] festivalitems = festivalAPI.getFestivals(pageNo).getItem();
		for (int i = 0; i < festivalitems.length; i++) {
			mainHome.add(festivalitems[i]);
		}

		
		foodItem[] fooditems = foodAPI.getFoods(pageNo).getItem();
		for (int i = 0; i < fooditems.length; i++) {
			mainHome.add(fooditems[i]);
		}

		if (attractionitems != null) {
			req.setAttribute("mainHome", mainHome);
		}
		
		

		req.getRequestDispatcher("/WEB-INF/index/index.jsp").forward(req, resp);
	}
}

