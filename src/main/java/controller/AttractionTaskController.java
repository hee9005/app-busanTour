package controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Attraction.attractionitem;
import data.views.views;
import util.AttractionDetailAPI;


@WebServlet("/attraction-task")
public class AttractionTaskController extends HttpServlet{

    @SuppressWarnings("unused")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<attractionitem> attractionitem = new LinkedList<>();
        String UC_SEQ = req.getParameter("no");
        SqlSessionFactory factory =
            (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
        try (SqlSession sqlSession = factory.openSession(true)) {
            List<views> viewsList = sqlSession.selectList("findView");
            boolean viewExists = false;
            for (views item : viewsList) {
                if (item.getTarget().equals(UC_SEQ)) {
                    viewExists = true;
                    break;
                }
            }
            if (viewExists) {
                sqlSession.update("view.updateView", UC_SEQ);
            } else {
                sqlSession.insert("view.createView", UC_SEQ);
            }
           
         
            
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
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

	
}
