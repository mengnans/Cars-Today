package dataAccess;

import models.Administrator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-19:08
 */

public class AdminMapperTest {

    @Test
    void createUserTest(){
        Administrator admin = new Administrator("root","5314");
        Administrator adminFound = AdminMapper.readAdminByAdminName(admin.getAdminName());
        // delete the old one
        if (adminFound != null){
            AdminMapper.deleteAdmin(adminFound);
        }
        // create a new one
        AdminMapper.createAdmin(admin);
        // find all
        ArrayList<Administrator> admins = AdminMapper.readAllAdmins();
        for (Administrator someAdmin: admins){
            System.out.println(someAdmin);
        }
        assert admins.size() == 1;
    }

}
