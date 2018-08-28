package dataAccess;

import models.User;
import utils.Utils;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-18:10
 */

public class UserMapper {

    /**
     * find a specific user, and create
     * a user object
     *
     * @param uid user's id
     * @return user object (if exists) or null(if doesn't exist)
     */
    public static User readUserById(long uid) {
        String sql = "SELECT * FROM user WHERE uid = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, uid);
            ResultSet resultSet = preparedStatement.executeQuery();

            String userName = null;
            String password = null;

            if (resultSet.next()) {
                userName = resultSet.getString("username");
                password = resultSet.getString("password");
            }

            if (userName != null) {
                User user = new User(uid, userName, password);
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * find a specific user, and create
     * a user object for him
     *
     * @param userName user's userName
     * @return user object (if exists) or null(if doesn't exist)
     */
    public static User readUserByUserName(String userName) {
        String sql = "SELECT * FROM user WHERE username = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();

            userName = null;
            String password = null;
            Long uid = -1L;

            if (resultSet.next()) {
                uid = resultSet.getLong("uid");
                userName = resultSet.getString("username");
                password = resultSet.getString("password");
            }

            if (userName != null) {
                User user = new User(uid, userName, password);
                return user;
            }
            // no user founded
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * find all users
     *
     * @return an array list that contains all user objects
     */
    public static ArrayList<User> readAllUsers() {
        String sql = "SELECT * FROM user";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<User> userList = new ArrayList<User>();

            while (resultSet.next()) {
                Long uid = resultSet.getLong("uid");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");

                User user = new User(uid, userName, password);

                userList.add(user);
            }

            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * insert a new user into database
     * please make sure, there's no existing user
     * with the same username in the business
     * logic layer
     *
     * @param user
     */
    public static void createUser(User user) {
        String sql = "INSERT INTO user (username, password) VALUES(?, ?)";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            String pwd = user.getPassword();
            String encryptedPwd = Utils.getMd5(pwd);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, encryptedPwd);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * think twice before you delete anything
     *
     * @param user
     */
    public static void deleteUser(User user) {
        String sql = "DELETE from user where uid = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setLong(1, user.getUid());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}