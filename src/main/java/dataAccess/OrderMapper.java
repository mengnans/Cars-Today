package dataAccess;

import models.Order;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-09-01-12:13
 */

public class OrderMapper {

    /**
     * find all orders
     *
     * @return an array list that contains all orders
     */
    public static ArrayList<Order> readAllOrdersByUserId(Long uId) {
        String sql = "SELECT * FROM orders where user_id = ? order by oid desc";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, uId);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Order> orders = new ArrayList<Order>();

            while (resultSet.next()) {
                Long oId = resultSet.getLong("oid");
                Long carId = resultSet.getLong("cars_id");
                Long userId = resultSet.getLong("user_id");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");
                Date date = resultSet.getDate("date");

                String statusString;
                switch (status) {
                    case 0:
                        statusString = "Initializing";
                        break;
                    case 1:
                        statusString = "Processing";
                        break;
                    case 2:
                        statusString = "Delivering";
                        break;
                    case 3:
                        statusString = "Delivered";
                        break;
                    default:
                        statusString = "Error";
                        break;
                }
                Order order = new Order(oId, carId, userId, address, phone, statusString, date);
                orders.add(order);
                if (!order.getStatus().equals("Delivered"))
                    updateOrder(order);
            }

            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * update a new order
     *
     * @param order a order object that contains all the
     *              info for the new bid object
     */
    public static void updateOrder(Order order) {
        String sql = "UPDATE orders SET status = ? where oid = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            String statusString = order.getStatus();
            int status;
            if (statusString.equals("Initializing"))
                status = 1;
            else if (statusString.equals("Processing"))
                status = 2;
            else
                status = 3;


            preparedStatement.setInt(1, status);
            preparedStatement.setLong(2, order.getOId());


            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a new order
     *
     * @param order a new order
     */
    public static void createOrder(Order order) {
        String sql = "INSERT INTO orders (cars_id, user_id, address, phone, status, date) VALUES(?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            Long carId = order.getCarId();
            Long userId = order.getUserId();
            String address = order.getAddress();
            String phone = order.getPhone();
            Date date = order.getDate();
            int status = 0;

            preparedStatement.setLong(1, carId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, phone);
            preparedStatement.setInt(5, status);
            preparedStatement.setDate(6, date);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
