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




 
@WebServlet("/index")
public class indexController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		attractionitem[] attractionitems = AttractionAPI.getAttractions().getItem();
		List<attractionitem> li = new LinkedList<>();
		for (int i = 0; i < attractionitems.length; i++) {
			li.add(attractionitems[i]);
		}


		if (attractionitems != null) {
			req.setAttribute("attractions", li);
		}

		req.getRequestDispatcher("/WEB-INF/index/index.jsp").forward(req, resp);
	}
}
