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
 * @create 2018-9-29 21:04:31
 */

@WebServlet("/user/car/info")
public class UserCarInfoController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userIdInSession = (Long) session.getAttribute("userId");
        if (userIdInSession == null) {
            forward("/login.jsp", req, resp);
            return;
        }

        String _id = req.getParameter("id");
        ArrayList<CarItem> _lstCar = CarMapper.readCarByID(_id);
        req.setAttribute("userId", userIdInSession);
        if (_lstCar.size() == 0) {
            forward("/user/carAdd.jsp", req, resp);
        } else {
            req.setAttribute("car", _lstCar.get(0));
            forward("/user/carEdit.jsp", req, resp);
        }
    }
}