package dataAccess;

import models.Bid;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-09-28-15:23
 */

public class BidMapper {

    /**
     * find all bids for a single user
     *
     * @return an array list that contains all bids
     * for that user
     */
    public static ArrayList<Bid> readAllBidsByUserId(Long uId) {
        String sql = "SELECT * FROM bids where user_id = ? order by bid desc";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, uId);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Bid> bids = new ArrayList<Bid>();

            while (resultSet.next()) {
                Long bId = resultSet.getLong("bid");
                Long carId = resultSet.getLong("cars_id");
                Long userId = resultSet.getLong("user_id");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String status = resultSet.getString("status");
                Date date = resultSet.getDate("date");
                double bidPrice = resultSet.getDouble("bid_price");
                Bid bid = new Bid(bId, carId, userId, address, phone, status, date, bidPrice);
                bids.add(bid);
            }

            return bids;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * update a bid
     *
     * @param bid a bid object that contains all new data
     *            for the new bid object
     */
    public static void updateBid(Bid bid) {
        String sql = "UPDATE bids SET status = ? where bid = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, bid.getStatus());
            preparedStatement.setLong(2, bid.getBid());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a new bid
     *
     * @param bid a new bid object
     */
    public static void createBid(Bid bid) {
        String sql = "INSERT INTO bids (cars_id, user_id, address, phone, status, date, bid_price) VALUES(?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            Long carId = bid.getCarId();
            Long userId = bid.getUserId();
            String address = bid.getAddress();
            String phone = bid.getPhone();
            Date date = bid.getDate();
            String status = "Waiting";
            double bidPrice = bid.getBidPrice();

            preparedStatement.setLong(1, carId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, status);
            preparedStatement.setDate(6, date);
            preparedStatement.setDouble(7, bidPrice);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
