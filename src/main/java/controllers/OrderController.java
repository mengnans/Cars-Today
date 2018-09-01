package controllers;

import dataAccess.CarMapper;
import dataAccess.OrderMapper;
import models.CarItem;
import models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-17:44
 */

@WebServlet("/order")
public class OrderController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userIdInSession = session.getAttribute("userId");
        if (userIdInSession != null) {
            ArrayList<Order> orders = OrderMapper.readAllOrdersByUserId((Long) userIdInSession);

            HashMap<Long, CarItem> cached = (HashMap<Long, CarItem>) session.getAttribute("cached");
            if (cached == null) {
                cached = new HashMap<Long, CarItem>();
            }

            if (orders.size() >= 1) {
                for (Order myOrder : orders) {
                    Long carId = myOrder.getCarId();
                    CarItem car = cached.get(carId);
                    // if it's not in cached
                    if (car == null) {
                        System.out.println(carId);
                        car = CarMapper.readCarByID(""+carId).get(0);
                        cached.put(carId, car);
                    }
                    myOrder.setCar(car);
                }
                req.setAttribute("orders", orders);
                session.setAttribute("cached", cached);
            } else {
                req.setAttribute("error", "Sorry, it seems like you don't have any order");
                forward("/error.jsp", req, resp);
            }
            forward("/order.jsp", req, resp);
        } else {
            forward("/login.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
