package dataaccess;

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
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "colinc";
    private static final String DBMS = "mysql";
    private static final String SERVER_NAME = "localhost";
    private static final String PORT_NUMBER = "3306";
    private static final String DB_NAME = "mvc";

    public static Connection getConnection() throws SQLException {

        // if there's a connection
        if (conn != null){
            return conn;
        } else {
            Properties connectionProps = new Properties();
            connectionProps.put("user", USER_NAME);
            connectionProps.put("password", PASSWORD);

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
