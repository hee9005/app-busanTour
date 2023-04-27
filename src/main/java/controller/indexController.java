package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Attraction.busanAttraction;
import data.sido.SidoResponse;
import util.AttractionAPI;
import util.SidoAPI;

@WebServlet("/index")
public class indexController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		busanAttraction BusanAttraction = AttractionAPI.getAttractions();
		
		if(BusanAttraction != null) {
			req.setAttribute("attractions", BusanAttraction.getItem());
		}
		
		req.getRequestDispatcher("/WEB-INF/index/index.jsp").forward(req, resp);
	}
}
