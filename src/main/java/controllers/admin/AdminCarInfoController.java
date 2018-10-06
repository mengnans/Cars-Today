package controllers.admin;

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
 * @create 2018-8-28 20:51:00
 */

@WebServlet("/admin/car/info")
public class AdminCarInfoController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // if admin didn't log in
        HttpSession session = req.getSession();
        Object adminIdInSession = session.getAttribute("adminId");
        if (adminIdInSession == null ){
            forward("/admin/login.jsp", req, resp);
        }

        String _id = req.getParameter("id");
        ArrayList<CarItem> _lstCar = CarMapper.readCarByID(_id);
        if (_lstCar.size() == 0) {
            forward("/admin/carAdd.jsp", req, resp);
        } else {
            req.setAttribute("car", _lstCar.get(0));
            forward("/admin/carEdit.jsp", req, resp);
        }
    }

}