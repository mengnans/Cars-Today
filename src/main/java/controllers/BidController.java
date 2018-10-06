package controllers;

import dataAccess.BidMapper;
import dataAccess.CarMapper;
import dataAccess.OrderMapper;
import models.Bid;
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
 * @create 2018-09-28-16:23
 */

@WebServlet("/bid")
public class BidController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userIdInSession = session.getAttribute("userId");
        if (userIdInSession != null) {
            ArrayList<Bid> bids = BidMapper.readAllBidsByUserId((Long) userIdInSession);

            String bidStatus = req.getParameter("bid");
            if (bidStatus != null && bidStatus.equals("success")) {
                req.setAttribute("bid_info",
                        "Bid Success, please come back later to check the status of the bids");
            } else {
                req.setAttribute("bid_info",
                        "We are taking care of your bids, please come back later to check the status of the bids");
            }

            // get cached car item data
            HashMap<Long, CarItem> cached = (HashMap<Long, CarItem>) session.getAttribute("cached");
            if (cached == null) {
                cached = new HashMap<Long, CarItem>();
            }

            if (bids.size() >= 1) {
                for (Bid myBid : bids) {
                    Long carId = myBid.getCarId();
                    CarItem car = cached.get(carId);
                    // if it's not in cached
                    if (car == null) {
                        car = CarMapper.readCarByID("" + carId).get(0);
                        cached.put(carId, car);
                    }
                    myBid.setCar(car);
                }
                req.setAttribute("bids", bids);
                session.setAttribute("cached", cached);
            } else {
                req.setAttribute("error", "Sorry, it seems like you don't have any bid");
                forward("/error.jsp", req, resp);
            }
            forward("/bid.jsp", req, resp);
        } else {
            forward("/login.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
