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

@WebServlet("/attraction")
public class AttractionController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		attractionitem[] attractionitems = AttractionAPI.getAttractions().getItem();
		List<attractionitem> att = new LinkedList<>();
		for (int i = 0; i < attractionitems.length; i++) {
			att.add(attractionitems[i]);
		}

	}
	

}