package controllers;

import dataAccess.BidMapper;
import dataAccess.CarMapper;
import dataAccess.OrderMapper;
import dataAccess.UserMapper;
import models.Bid;
import models.CarItem;
import models.Order;
import models.User;

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
 * @create 2018-09-01-16:34
 */
@WebServlet("/close-bid")
public class CloseController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long userIdInSession = (Long) session.getAttribute("userId");
        if (userIdInSession != null) {
            Long cid = Long.valueOf(req.getParameter("cid"));
            ArrayList<Bid> bids = BidMapper.readAllBidsByCarId(cid);
            double maxPrice = 0;
            Bid maxBid = null;

            if (bids.size() == 0){
                // update car db
                CarItem car = CarMapper.readCarByID(""+cid).get(0);
                car.setStock(0);
                CarMapper.updateCar(car);

                req.setAttribute("bid_info",
                        "Auction closed, no valid bid");

                forward("/user/home", req, resp);
            }

            for (Bid bid: bids
                 ) {
                double price = bid.getBidPrice();
                if (price > maxPrice) {
                    maxBid = bid;
                }
                bid.setStatus("Failed Bid");
            }

            if (maxBid != null) {
                maxBid.setStatus("Successful Bid");
            }

            // update bid db
            for (Bid bid: bids
            ) {
                BidMapper.updateBid(bid);
            }

            // update car db
            CarItem car = CarMapper.readCarByID(""+cid).get(0);
            car.setStock(0);
            CarMapper.updateCar(car);

            // update order db
            String address = maxBid.getAddress();
            String phone = maxBid.getPhone();
            Order order = new Order(cid, maxBid.getUserId(), address, phone);
            OrderMapper.createOrder(order);

            User user = UserMapper.readUserById(maxBid.getUserId());
            String userName = user.getUserName();
            double price = maxBid.getBidPrice();

            req.setAttribute("bid_info",
                    "Auction closed, " + userName + " with " + price + "$ win the auction");

            forward("/user/home", req, resp);

        } else {
            forward("/login.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Long userIdInSession = (Long) session.getAttribute("userId");
        if (userIdInSession == null) {
            forward("/login.jsp", req, resp);
        }

        Long cid = Long.valueOf(req.getParameter("cid"));

        boolean purchaseStatus = purchaseCar(cid, session);

        if (purchaseStatus == true) {
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");

            Order order = new Order(cid, userIdInSession, address, phone);

            OrderMapper.createOrder(order);

            forward("/order?purchase=success", req, resp);
        } else {
            req.setAttribute("error", "Sorry, the car you are buying is sold out");

            forward("/error.jsp", req, resp);
        }
    }

    /**
     * synchronized method makes sure only one thread is accessing the
     * stock of the car, and update it.
     * This can make sure, if there's only one car, two buyers cannot
     * buy it at the same time.
     *
     * @param cid     the id of the car
     * @param session the http session, used to change the cached data
     * @return whether the purchase is successful or not
     */
    private synchronized boolean purchaseCar(Long cid, HttpSession session) {
        CarItem car;

        HashMap<Long, CarItem> cached = (HashMap<Long, CarItem>) session.getAttribute("cached");
        if (cached == null) {
            cached = new HashMap<Long, CarItem>();
        }

        // we don't read car from cache
        // since the data of car (especially stock)
        // might be changed by other users' purchasing
        car = CarMapper.readCarByID("" + cid).get(0);

        int carStock = car.getStock();
        if (carStock >= 1) {
            car.setStock(carStock - 1);
            if (CarMapper.updateCar(car)) {
                // update car info in cache
                cached.put(cid, car);
                session.setAttribute("cached", cached);
                return true;
            }
            // update car in db
            return false;
        } else {
            return false;
        }
    }
}