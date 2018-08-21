package dataaccess;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-18:31
 */

public class DBUtilsTest {

    @Test
    void getConnection(){
        Connection conn = null;
        Connection conn2 = null;
        try {
            conn = DBUtils.getConnection();
        } catch (SQLException e) {
            System.out.println("First connection failed");
            e.printStackTrace();
        }
        assert conn != null;

        try {
            conn2 = DBUtils.getConnection();
        } catch (SQLException e) {
            System.out.println("Second connection failed");
            e.printStackTrace();
        }

        assert conn == conn2;

    }

}
