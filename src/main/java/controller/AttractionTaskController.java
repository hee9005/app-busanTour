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

import util.AttractionDetailAPI;

@WebServlet("/attraction-task")
public class AttractionTaskController extends HttpServlet{
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<attractionitem> attractionitem = new LinkedList<>();
		String UC_SEQ = req.getParameter("no");
		attractionitem[] attractionitems = AttractionDetailAPI.getAttractions(UC_SEQ).getItem();
		for (int i = 0; i < attractionitems.length; i++) {
		    attractionitem.add(attractionitems[i]);
		}
		if (attractionitem.isEmpty()) {
		    req.getRequestDispatcher("/WEB-INF/views/not-found.jsp").forward(req, resp);
		} else {
		    req.setAttribute("item", attractionitem.get(0));
		    req.getRequestDispatcher("/WEB-INF/views/attractionDetail.jsp").forward(req, resp);
		}
	}
}