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
import java.util.ArrayList;

/**
 * @author Ye Yan
 * @create 2018-9-29 20:12:54
 */

@WebServlet("/user/home")
public class UserHomeController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long userIdInSession = (Long) session.getAttribute("userId");
        if (userIdInSession == null) {
            forward("/login.jsp", req, resp);
        return;
    }


        ArrayList<CarItem> _lstCar = CarMapper.readUserUsedCar(userIdInSession + "");
        req.setAttribute("_lstCar", _lstCar);
        String bidInfo = (String) req.getAttribute("bid_info");
        if(bidInfo == null || bidInfo.length() <= 0){
            String message;
            if(_lstCar.size() == 0) {
                message = "you can create an auction for your used car by clicking Add New Car button on the top.";
            } else {
                message = "you can close/edit your auction here.";
            }
            req.setAttribute("bid_info",
                    "Welcome to Sell My Car Center, " + message);
        }
        forward("/user/home.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}