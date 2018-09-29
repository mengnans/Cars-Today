package controllers.user;

import controllers.MyServlet;
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
 * @create 2018-9-29 21:04:39
 */

@WebServlet("/user/car/add")
public class UserCarAddController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long userIdInSession = (Long) session.getAttribute("userId");
        if (userIdInSession == null) {
            forward("/login.jsp", req, resp);
            return;
        }

        String priceString = req.getParameter("price");
        String stockString = req.getParameter("stock");
        String sellerIdString = req.getParameter("seller_id");
        int price, stock, seller_id;
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

        try {
            seller_id = Integer.parseInt(sellerIdString);
        } catch (Exception exception) {
            seller_id = 0;
        }


        CarItem _catItem = new CarItem();
        _catItem.setVersion(0);
        _catItem.setBrand(req.getParameter("brand"));
        _catItem.setCarType(req.getParameter("car_type"));
        _catItem.setCarName(req.getParameter("car_name"));
        _catItem.setTransmission(req.getParameter("transmission"));
        _catItem.setEngineType(req.getParameter("engine_type"));
        _catItem.setImage(req.getParameter("image"));
        _catItem.setPrice(price);
        _catItem.setLocation(req.getParameter("location"));
        _catItem.setMilage(0);
        _catItem.setDescription(req.getParameter("description"));
        _catItem.setStock(stock);
        _catItem.setSellerId(seller_id);
        CarMapper.createCar(_catItem);
        forward("/user/home", req, resp);
    }

}