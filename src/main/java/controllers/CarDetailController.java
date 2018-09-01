package controllers;

import dataAccess.CarMapper;
import models.CarItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

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

        Long cid = Long.valueOf(req.getParameter("cid"));
//        CarItem carItem = CarMapper
        cid = 1L;
        if (cid == null) {
            req.setAttribute("error","Car not found");
            forward("/error.jsp", req, resp);
        }

        HashMap<Long, CarItem> cached = (HashMap<Long, CarItem>) session.getAttribute("cached");
        if (cached == null){
            cached = new HashMap<Long, CarItem>();
        }

        CarItem car = cached.get(cid);
        // if it's not in cached
        if (car == null){
            car = CarMapper.readCarById(cid);
            cached.put(cid, car);
        }

        req.setAttribute("car", car);
        session.setAttribute("cached", cached);

        forward("/detail.jsp", req, resp);

    }
}
