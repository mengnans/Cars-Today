package controllers;

import dataAccess.CarMapper;
import models.CarItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-29-16:48
 */

@WebServlet("/detail")
public class CarDetailController extends MyServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // if user didn't log in
        HttpSession session = req.getSession();
        Object userIdInSession = session.getAttribute("userId");
        if (userIdInSession == null ){
            forward("/login.jsp", req, resp);
        }

        String cid = req.getParameter("cid");
//        CarItem carItem = CarMapper

        cid = "1";

        if (cid == null) {
            req.setAttribute("error","Car not found");
            forward("/error.jsp", req, resp);
        }

        CarItem carItem = new CarItem(1L,"volkswagen","SUV","tiguan","Auto","petrol engine", "./images/tiguan.jpg",32888,-1L,"Melbourne", 0, "this is description",22);

        req.setAttribute("car", carItem);

        forward("/detail.jsp", req, resp);

    }
}
