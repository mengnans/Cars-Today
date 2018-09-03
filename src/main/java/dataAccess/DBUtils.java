package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-18:16
 */

public class DBUtils {

    // db parameters
    private static Connection conn = null;
    private static final String USER_NAME = "b357bae083caf3";
    private static final String PASSWORD = "048b8249";
    private static final String DBMS = "mysql";
    private static final String SERVER_NAME = "us-cdbr-iron-east-01.cleardb.net";
    private static final String PORT_NUMBER = "3306";
    private static final String DB_NAME = "heroku_f7f811610f984f9";
    public static final String MYSQL_AUTO_RECONNECT = "autoReconnect";
    public static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

//    mysql://b357bae083caf3:048b8249@us-cdbr-iron-east-01.cleardb.net/heroku_f7f811610f984f9?reconnect=true


    public static Connection getConnection() throws SQLException {

        // if there's a connection
        if (conn != null){
            return conn;
        } else {
            Properties connectionProps = new Properties();
            connectionProps.put("user", USER_NAME);
            connectionProps.put("password", PASSWORD);
            connectionProps.put(MYSQL_AUTO_RECONNECT, "true");
            connectionProps.put(MYSQL_MAX_RECONNECTS, "100");

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


            conn = DriverManager.getConnection(
                    "jdbc:" + DBMS + "://" +
                            SERVER_NAME +
                            ":" + PORT_NUMBER + "/"
                            + DB_NAME,
                    connectionProps);

            System.out.println("Connected to database");
            return conn;
        }
    }

}
