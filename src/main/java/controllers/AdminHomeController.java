package controllers;

import dataAccess.CarMapper;
import models.CarItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Ye Yan
 * @create 2018-8-28 20:51:00
 */

@WebServlet("/admin/home")
public class AdminHomeController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // if admin didn't log in
        HttpSession session = req.getSession();
        Object adminIdInSession = session.getAttribute("adminId");
        if (adminIdInSession == null ){
            forward("/admin/login.jsp", req, resp);
        }


        ArrayList<CarItem>  _lstCar = CarMapper.readCar();
        req.setAttribute("_lstCar", _lstCar);
        forward("/admin/home.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}