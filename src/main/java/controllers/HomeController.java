package controllers;

import dataAccess.UserMapper;
import models.CarItem;
import models.User;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        ArrayList<CarItem> _lstCar = new ArrayList<CarItem>();
        CarItem _demoItem = new CarItem();
        _demoItem.setDescription("DemoDescription");
        _demoItem.setBrand("DemoBrand");
        _demoItem.setCarName("DemoCarName");
        _lstCar.add(_demoItem);

        _demoItem = new CarItem();
        _demoItem.setDescription("DemoDescription1");
        _demoItem.setBrand("DemoBrand1");
        _demoItem.setCarName("DemoCarName1");
        _lstCar.add(_demoItem);

        _demoItem = new CarItem();
        _demoItem.setDescription("DemoDescription2");
        _demoItem.setBrand("DemoBrand2");
        _demoItem.setCarName("DemoCarName2");
        _lstCar.add(_demoItem);

        req.setAttribute("_lstCar", _lstCar);
        forward("/home.jsp", req, resp);
    }

}