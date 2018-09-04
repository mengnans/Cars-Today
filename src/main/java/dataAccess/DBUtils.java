package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-18:16
 */

/**
 * Utils class used for get db connections
 */
public class DBUtils {

    private static final String USER_NAME = "b357bae083caf3";
    private static final String PASSWORD = "048b8249";
    private static final String DBMS = "mysql";
    private static final String SERVER_NAME = "us-cdbr-iron-east-01.cleardb.net";
    private static final String DB_NAME = "heroku_f7f811610f984f9";
    private static Connection conn;

    public static Connection getConnection() throws SQLException {
        // if there's a connection
        if (conn != null) {

            // and if the connection is valid
            if (conn.isValid(333)){
                // return the connection
                return conn;
            }
            // otherwise
            // close the previous connection first
            // to avoid connection error
            conn.close();
        }

        // establish a new connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:"
                    + DBMS + "://"
                    + SERVER_NAME + "/"
                    + DB_NAME
                    , USER_NAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
