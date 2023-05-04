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




 
@WebServlet("/index")
public class indexController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Object> mainHome = new LinkedList<>();
			
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
			pageNo=req.getParameter("page");
		}
		attractionitem[] attractionitems = AttractionAPI2.getAttractions(pageNo).getItem();
		festivalitem[] festivalitems = festivalAPI2.getFestivals(pageNo).getItem();
		foodItem[] fooditems = foodAPI2.getFoods(pageNo).getItem();
		if (attractionitems != null&&festivalitems != null&&fooditems != null) {

		for (int i = 0; i < attractionitems.length; i++) {
			mainHome.add(attractionitems[i]);
		}

		for (int i = 0; i < festivalitems.length; i++) {
			mainHome.add(festivalitems[i]);
		}

		
		for (int i = 0; i < fooditems.length; i++) {
			mainHome.add(fooditems[i]);
		}

			req.setAttribute("mainHome", mainHome);
		
		int total = AttractionAPI2.getAttractions(pageNo).getTotalCount();
		total += festivalAPI2.getFestivals(pageNo).getTotalCount();
		total += foodAPI2.getFoods(pageNo).getTotalCount();

		int lastPage = total / 10 +(total % 10 > 0 ? 1 : 0);
		
		int last = (int)Math.ceil(p / 5.0) * 5;
		int start = last -4;
		
		last = last > lastPage ? lastPage : last;

		req.setAttribute("start", start); // (1~5) ==> 1 / (6~10) ==>6 / (11~15) ==> 11
		req.setAttribute("last", last); // (1~5) ==> 5 / (6~10) ==>10 / (11~15) ==> 15
		
		
		boolean existPrev = p >=6;
		boolean existNext = lastPage > last;
		req.setAttribute("existPrev", existPrev);
		req.setAttribute("existNext", existNext);
	
	
		}
		req.getRequestDispatcher("/WEB-INF/index/index.jsp").forward(req, resp);
	}
}

