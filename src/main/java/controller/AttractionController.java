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
import util.AttractionAPI;
import util.AttractionAPI2;
import util.foodAPI2;

@WebServlet("/attraction")
public class AttractionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int p;
		if (req.getParameter("page") == null) {
			p = 1;
		} else {
			p = Integer.parseInt(req.getParameter("page"));
		}
		
		String pageNo;
		if(req.getParameter("pageNo") ==null) {
			pageNo ="1";
		}else {
			pageNo=req.getParameter("page");
		}
		attractionitem[] attractionitems = AttractionAPI.getAttractions(pageNo).getItem();
		List<attractionitem> att = new LinkedList<>();
		for (int i = 0; i < attractionitems.length; i++) {
			att.add(attractionitems[i]);
		}
		
		if (attractionitems != null) {
			req.setAttribute("attractions", att);
		}
		
int total = AttractionAPI2.getAttractions(pageNo).getTotalCount();
		
		int lastPage = total / 10 + (total % 10 > 0 ? 1 : 0);
		
		int last =  (int)Math.ceil(p / 5.0) * 5;
		int start = last - 4;
		
		last = last > lastPage ? lastPage : last;
		
		req.setAttribute("start", start); // (1~5) ==> 1 / (6~10) ==>6 / (11~15) ==> 11
		req.setAttribute("last", last); // (1~5) ==> 5 / (6~10) ==>10 / (11~15) ==> 15

		boolean existPrev = p >=6;
		boolean existNext = lastPage > last;
		req.setAttribute("existPrev", existPrev);
		req.setAttribute("existNext", existNext);
		
		req.getRequestDispatcher("/WEB-INF/index/attractionScreen.jsp").forward(req, resp);


	}
	

}
