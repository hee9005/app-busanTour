package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

@WebServlet("/search")
public class searchController extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    List<Object> mainHome = new LinkedList<>();
	    int p;
	    if(req.getParameter("page") == null) {
	        p=1;
	    } else {
	        p=Integer.parseInt(req.getParameter("page"));
	    }
	    String pageNo;
	    if(req.getParameter("pageNo") ==null) {
	        pageNo ="1";
	    } else {
	        pageNo=req.getParameter("page");
	    }

	    // 검색어를 가져옴
	    String search = req.getParameter("search");

	    attractionitem[] attractionitems = AttractionAPI2.getAttractions(pageNo).getItem();
	    festivalitem[] festivalitems = festivalAPI2.getFestivals(pageNo).getItem();
	    foodItem[] fooditems = foodAPI2.getFoods(pageNo).getItem();

	    if (attractionitems != null && festivalitems != null && fooditems != null) {
	        for (int i = 0; i < attractionitems.length; i++) {
	            mainHome.add(attractionitems[i]);
	        }

	        for (int i = 0; i < festivalitems.length; i++) {
	            mainHome.add(festivalitems[i]);
	        }

	        for (int i = 0; i < fooditems.length; i++) {
	            mainHome.add(fooditems[i]);
	        }

	        // 검색어가 포함된 객체만 필터링하여 request에 추가
	        List<Object> filteredList = mainHome.stream()
	                .filter(obj -> {
	                    if (obj instanceof attractionitem) {
	                        attractionitem attraction = (attractionitem) obj;
	                        return attraction.getMAIN_TITLE().toLowerCase().contains(search.toLowerCase());
	                    }
	                  if (obj instanceof festivalitem) {
	                        festivalitem festival = (festivalitem) obj;
	                        return festival.getMAIN_TITLE().toLowerCase().contains(search.toLowerCase());
	                    }
	                  if (obj instanceof foodItem) {
	                        foodItem food = (foodItem) obj;
	                        return food.getMAIN_TITLE().toLowerCase().contains(search.toLowerCase());
	                    } else {
	                        return false;
	                    }
	                })
	                .collect(Collectors.toList());
	        System.out.print(filteredList);
	        req.setAttribute("filteredList", filteredList);
	        req.getRequestDispatcher("/WEB-INF/index/search.jsp").forward(req, resp);
	    }
	}
}
