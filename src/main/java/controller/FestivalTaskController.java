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
import util.AttractionDetailAPI;
import util.FestivalDetailAPI;

@WebServlet("/festival-task")
public class FestivalTaskController extends HttpServlet{
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<festivalitem> festivalitem = new LinkedList<>();
		String UC_SEQ = req.getParameter("no");
		festivalitem[] festivalitems = FestivalDetailAPI.getFestivals(UC_SEQ).getItem();
		for (int i = 0; i < festivalitems.length; i++) {
		    festivalitem.add(festivalitems[i]);
		}
		if (festivalitem.isEmpty()) {
			req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);
		}else {
		    req.setAttribute("item", festivalitem.get(0));
		    req.getRequestDispatcher("/WEB-INF/views/festivalDetail.jsp").forward(req, resp);
		}
	}
	

}
