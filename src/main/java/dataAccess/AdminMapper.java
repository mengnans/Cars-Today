package dataAccess;

import models.Administrator;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-18:10
 */

public class AdminMapper {

    /**
     * find a specific administrator
     * ,and create a admin object
     * @param aid admin's id
     * @return admin (if exists) or null(if doesn't exist)
     */
    public static Administrator readAdminById(long aid) {
        String sql = "SELECT * FROM administrator WHERE aid = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, aid);
            ResultSet resultSet = preparedStatement.executeQuery();

            String adminName = null;
            String password = null;

            if (resultSet.next()) {
                adminName = resultSet.getString("adminname");
                password = resultSet.getString("password");
            }

            if (adminName != null) {
                Administrator admin = new Administrator(aid, adminName, password);
                return admin;
            }
            // no admin founded
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * find a specific admin, and create
     * a admin object
     *
     * @param adminName admin's adminName
     * @return admin (if exists) or null(if doesn't exist)
     */
    public static Administrator readAdminByAdminName(String adminName) {
        String sql = "SELECT * FROM administrator WHERE adminname = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, adminName);
            ResultSet resultSet = preparedStatement.executeQuery();

            adminName = null;
            String password = null;
            Long aid = null;

            if (resultSet.next()) {
                aid = resultSet.getLong("aid");
                adminName = resultSet.getString("adminName");
                password = resultSet.getString("password");
            }

            if (adminName != null) {
                Administrator admin = new Administrator(aid, adminName, password);
                return admin;
            }
            // no admin founded
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * find all admins
     * @return an array list that contains all admins
     */
    public static ArrayList<Administrator> readAllAdmins() {
        String sql = "SELECT * FROM administrator";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Administrator> adminList = new ArrayList<Administrator>();

            while (resultSet.next()) {
                Long aid = resultSet.getLong("aid");
                String adminName = resultSet.getString("adminname");
                String password = resultSet.getString("password");

                Administrator admin = new Administrator(aid, adminName, password);

                adminList.add(admin);
            }

            return adminList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * insert a new admin into database
     * please make sure, there's no existing admin
     * with the same adminname in the business
     * logic layer
     * @param admin
     */
    public static void createAdmin(Administrator admin) {
        String sql = "INSERT INTO administrator (adminname, password) VALUES(?, ?)";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            String pwd = admin.getPassword();
            String encryptedPwd = Utils.getMd5(pwd);

            preparedStatement.setString(1, admin.getAdminName());
            preparedStatement.setString(2, encryptedPwd);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * think twice before you delete anything
     * @param admin
     */
    public static void deleteAdmin(Administrator admin) {
        String sql = "DELETE from administrator where aid = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setLong(1, admin.getAid());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
