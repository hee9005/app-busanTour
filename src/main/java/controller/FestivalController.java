package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Festival.festivalitem;
import util.festivalAPI;


@WebServlet("/festival")
public class FestivalController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageNo;
		if(req.getParameter("pageNo") ==null) {
			pageNo ="1";
		}else {
			pageNo=req.getParameter("pageNo");
		}
		festivalitem[] festivalitems = festivalAPI.getFestivals(pageNo).getItem();
		List<festivalitem> fes = new LinkedList<>();
		for (int i = 0; i < festivalitems.length; i++) {
			fes.add(festivalitems[i]);
		}

		if (festivalitems != null) {
			req.setAttribute("festivals", fes);
		}
		
		req.getRequestDispatcher("/WEB-INF/index/festivalScreen.jsp").forward(req, resp);
		
	}

}
