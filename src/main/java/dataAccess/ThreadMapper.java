package dataAccess;

import models.ThreadItem;
import models.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-18:10
 */

public class ThreadMapper {

    /**
     * insert a new threadItem into database
     *
     * @param threadItem
     */
    public void createThread(ThreadItem threadItem) {
        String _sql = "INSERT INTO threads (uid, username, datetime, header, content) VALUES('"
                + threadItem.getUid() + "', '"
                + threadItem.getUserName() + "', '"
                + threadItem.getDateTime() + "', '"
                + threadItem.getHeader() + "', '"
                + threadItem.getContent() + "')";
        ExecuteNonQuerySql(_sql);
    }

    /**
     * find all users
     *
     * @return an array list that contains all user objects
     */
    public ArrayList<ThreadItem> readThreadByUser(User argUser) {
        String _sql = "SELECT * FROM threads WHERE uid ='" + argUser.getUid() + "'";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToThreads(resultSet);
    }

    /**
     * find all users
     *
     * @return an array list that contains all user objects
     */
    public ArrayList<ThreadItem> readThreadById(long tid) {
        String _sql = "SELECT * FROM threads WHERE tid ='" + tid + "'";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToThreads(resultSet);
    }

    /**
     * find all users
     *
     * @return an array list that contains all user objects
     */
    public ArrayList<ThreadItem> readThreadAll() {
        String _sql = "SELECT * FROM threads";
        ResultSet resultSet = ExecuteQuerySql(_sql);
        return ConvertQueryResultToThreads(resultSet);
    }

    public ArrayList<ThreadItem> ConvertQueryResultToThreads(ResultSet argResultSet) {
        ArrayList<ThreadItem> _lstThread = new ArrayList<ThreadItem>();
        try {
            while (argResultSet.next()) {
                ThreadItem _threadItem = new ThreadItem();
                _threadItem.setTid(argResultSet.getLong("tid"));
                _threadItem.setUid(argResultSet.getLong("uid"));
                _threadItem.setUserName(argResultSet.getString("username"));
                _threadItem.setDateTime(argResultSet.getDate("datetime"));
                _threadItem.setHeader(argResultSet.getString("header"));
                _threadItem.setContent(argResultSet.getString("content"));
                _lstThread.add(_threadItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _lstThread;
    }

    public void updateThread(ThreadItem threadItem) {
        String _sql =
                "UPDATE threads SET header= '" + threadItem.getHeader() + "', content= '" + threadItem.getContent() + "' WHERE tid = " + "'" + threadItem.getTid() + "'";
        ExecuteNonQuerySql(_sql);
    }

    /**
     * Delete a threadItem from the database
     *
     * @param threadItem
     */
    public void deleteThread(ThreadItem threadItem) {
        String _sql = "DELETE from threads WHERE tid = " + "'" + threadItem.getTid() + "'";
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
        return null;
    }

}