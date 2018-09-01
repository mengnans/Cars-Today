package dataAccess;

import models.Administrator;
import models.Order;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-09-01-12:13
 */

public class OrderMapper {

    /**
     * find all orders
     * @return an array list that contains all orders
     */
    public static ArrayList<Order> readAllOrdersByUserId(Long uId) {
        String sql = "SELECT * FROM orders where user_id = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1,uId);

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Order> orders = new ArrayList<Order>();

            while (resultSet.next()) {
                Long oId = resultSet.getLong("oid");
                Long carId = resultSet.getLong("cars_id");
                Long userId = resultSet.getLong("user_id");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");

                String statusString;
                switch (status) {
                    case 0: statusString = "Initializing"; break;
                    case 1: statusString = "Processing"; break;
                    case 2: statusString = "Delivering"; break;
                    case 3: statusString = "Closed"; break;
                    default: statusString = "Error"; break;
                }
                Order order = new Order(oId, carId, userId, address, phone, statusString);
                orders.add(order);
                if (!order.getStatus().equals("Closed"))
                    updateOrder(order);
            }

            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * create a new order
     * @param order a new order
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
                status  = 1;
            else if (statusString.equals("Processing"))
                status = 2;
            else
                status = 3;


            preparedStatement.setInt(1, status);
            preparedStatement.setLong(2,order.getoId());


            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * create a new order
     * @param order a new order
     */
    public static void createOrder(Order order) {
        String sql = "INSERT INTO orders (cars_id, user_id, address, phone, status) VALUES(?, ?, ?, ?, ?)";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            Long carId = order.getCarId();
            Long userId = order.getUserId();
            String address = order.getAddress();
            String phone = order.getPhone();
            int status = 0;

            preparedStatement.setLong(1, carId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,phone);
            preparedStatement.setInt(5,status);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
