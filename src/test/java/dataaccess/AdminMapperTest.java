package dataaccess;

import domain.Administrator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-19:08
 */

public class AdminMapperTest {

    private static AdminMapper adminMapper;

    static {
        adminMapper = new AdminMapper();
    }

    @Test
    void createUserTest(){
        Administrator admin = new Administrator("root","5314");
        Administrator adminFound = adminMapper.readAdminByAdminName(admin.getAdminName());
        // delete the old one
        if (adminFound != null){
            adminMapper.deleteUser(adminFound);
        }
        // create a new one
        adminMapper.createAdmin(admin);
        // find all
        ArrayList<Administrator> admins = adminMapper.readAllAdmins();
        for (Administrator someAdmin: admins){
            System.out.println(someAdmin);
        }
    }

}
