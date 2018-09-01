package controllers;

import dataAccess.CarMapper;
import dataAccess.UserMapper;
import models.CarItem;
import models.User;
import utils.Utils;

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

@WebServlet("/home")
public class HomeController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // if user didn't log in
        HttpSession session = req.getSession();
        Object userIdInSession = session.getAttribute("userId");
        if (userIdInSession == null ){
            forward("/login.jsp", req, resp);
        }


        String _brand = req.getParameter("brand");
        ArrayList<CarItem> _lstCar;
        if (_brand == null || _brand.isEmpty()) {
            _lstCar = CarMapper.readCar();
        } else {
            _lstCar = CarMapper.readCarByBrand(_brand);
        }

        ArrayList<String> _lstBrand = CarMapper.readAllBrand();
        req.setAttribute("_lstBrand", _lstBrand);
        req.setAttribute("_lstCar", _lstCar);
        forward("/home.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}