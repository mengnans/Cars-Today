package dataaccess;

import domain.ThreadItem;
import domain.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-18:10
 */

public class ThreadMapper {

    /**
     * find a specific user, and create
     * a user object
     *
     * @param tid user's id
     * @return user object (if exists) or null(if doesn't exist)
     */
    public User readThreadById(long tid) {
        String sql = "SELECT * FROM threads WHERE tid = ?";
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, tid);
            ResultSet resultSet = preparedStatement.executeQuery();

            String userName = null;
            String password = null;

            if (resultSet.next()) {
                userName = resultSet.getString("username");
                password = resultSet.getString("password");
            }

            if (userName != null) {
                User user = new User(tid, userName, password);
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
     * find all users
     *
     * @return an array list that contains all user objects
     */
    public ArrayList<ThreadItem> readThreadByUser(User argUser) {
        String _sql = "SELECT * FROM threads WHERE uid ='" + argUser.getUid() + "'";

        ArrayList<ThreadItem> _lstThread = new ArrayList<ThreadItem>();
        ResultSet resultSet = ExecuteQuerySql(_sql);
        while (resultSet.next()) {
            Long uid = resultSet.getLong("uid");
            String userName = resultSet.getString("username");
            String password = resultSet.getString("password");

            User user = new User(uid, userName, password);

            _lstThread.add(user);
        }
        return _lstThread;
    }

    /**
     * insert a new threadItem into database
     *
     * @param threadItem
     */
    public void createThread(ThreadItem threadItem) {
        String _sql = "INSERT INTO threads (username, password) VALUES(?, ?)";
        ExecuteNonQuerySql(_sql);
    }

    /**
     * Delete a threadItem from the database
     *
     * @param threadItem
     */
    public void deleteThread(ThreadItem threadItem) {
        String _sql = "DELETE from threads where tid = " + "'" + threadItem.getTid() + "'";
        ExecuteNonQuerySql(_sql);
    }

    /**
     * Do an sql execution
     *
     * @param argSql The sql command
     */
    private void ExecuteNonQuerySql(String argSql) {
        Connection _connection = null;
        try {
            _connection = DBUtils.getConnection();
            Statement statement = _connection.createStatement();
            statement.execute(argSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Do an sql query
     *
     * @param argSql The sql command
     */
    private ResultSet ExecuteQuerySql(String argSql) {
        Connection _connection = null;
        try {
            _connection = DBUtils.getConnection();
            Statement statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery(argSql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}