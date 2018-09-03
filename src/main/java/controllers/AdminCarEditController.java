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
 * @author Ye Yan
 * @create 2018-8-28 20:51:00
 */

@WebServlet("/admin/car/edit")
public class AdminCarEditController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // if admin didn't log in
        HttpSession session = req.getSession();
        Object adminIdInSession = session.getAttribute("adminId");
        if (adminIdInSession == null) {
            forward("/admin/login.jsp", req, resp);
        }

        String priceString = req.getParameter("price");
        String stockString = req.getParameter("stock");
        int price, stock;
        try {
            price = Integer.parseInt(priceString);

        } catch (Exception exception) {
            price = 0;
        }

        try {
            stock = Integer.parseInt(stockString);

        } catch (Exception exception) {
            stock = 0;
        }



        CarItem _catItem = new CarItem();
        _catItem.setCarId(Long.parseLong(req.getParameter("cars_id")));
        _catItem.setBrand(req.getParameter("brand"));
        _catItem.setCarType(req.getParameter("car_type"));
        _catItem.setCarName(req.getParameter("car_name"));
        _catItem.setTransmission(req.getParameter("transmission"));
        _catItem.setEngineType(req.getParameter("engine_type"));
        _catItem.setImage(req.getParameter("image"));
        _catItem.setPrice(price);
        _catItem.setLocation("");
        _catItem.setMilage(0);
        _catItem.setDescription(req.getParameter("description"));
        _catItem.setStock(stock);
        CarMapper.updateCar(_catItem);
        forward("/admin/home", req, resp);
    }

}