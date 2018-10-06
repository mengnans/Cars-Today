package controllers;

import dataAccess.BidMapper;
import dataAccess.CarMapper;
import models.Bid;
import models.CarItem;

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
@WebServlet("/add-bid")
public class AddBidController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userIdInSession = session.getAttribute("userId");
        if (userIdInSession != null) {
            Long cid = Long.valueOf(req.getParameter("cid"));
            req.setAttribute("cid", cid);
            forward("/add-bid.jsp", req, resp);
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

        String message = createBid(req, cid, userIdInSession);
        if ("Success".equals(message)) {
            forward("/bid?bid=success", req, resp);
        } else {
            req.setAttribute("error", message);
            forward("/error.jsp", req, resp);
        }
    }

    private synchronized String createBid(HttpServletRequest req, Long cid, Long userId) {
        CarItem car = CarMapper.readCarByID("" + cid).get(0);
        int stock = car.getStock();
        if (stock > 0){
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            double bidPrice = Double.parseDouble(req.getParameter("price"));
            // lower than start price
            if(bidPrice < car.getPrice()) {
                return "Invalid auction, your bid price must be higher than start pirce: "  + car.getPrice();
            }
            Bid bid = new Bid(cid, userId, address, phone, bidPrice);
            BidMapper.createBid(bid);
            return "Success";
        }
        // the auction is closed
        else {
            return "Sorry, the auction is closed";
        }

    }


}