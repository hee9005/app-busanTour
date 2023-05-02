package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Attraction.attractionitem;
import util.AttractionDetailAPI;

@WebServlet("/attraction-task")
public class AttractionTaskController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		attractionitem item = AttractionDetailAPI.findByDesertionNO(no);
		if(item == null) {
			req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);	
	}else {
		req.setAttribute("item", item);
		req.getRequestDispatcher("/WEB-INF/views/attractionDetail.jsp").forward(req, resp);
	}

}
}
