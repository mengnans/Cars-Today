package controllers;

import dataAccess.CarMapper;
import dataAccess.OrderMapper;
import dataAccess.UserMapper;
import models.CarItem;
import models.Order;
import models.User;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-09-01-16:34
 */


@WebServlet("/purchase")
public class PurchaseController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userIdInSession = session.getAttribute("userId");
        if (userIdInSession != null ){
            Long cid = Long.valueOf(req.getParameter("cid"));
            req.setAttribute("cid",cid);
            forward("/purchase.jsp", req, resp);
        } else {
            forward("/login.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long userIdInSession = (Long) session.getAttribute("userId");
        if (userIdInSession == null ) {
            forward("/login.jsp", req, resp);
        }

        Long cid = Long.valueOf(req.getParameter("cid"));
        CarItem car = CarMapper.readCarByID(""+cid).get(0);
        int carStock = car.getStock();
        if (carStock >= 1){
            car.setStock(carStock - 1);
        }

        // update stock here

        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        Order order = new Order(cid, userIdInSession, address, phone);

        OrderMapper.createOrder(order);

        forward("/order", req, resp);

    }
}