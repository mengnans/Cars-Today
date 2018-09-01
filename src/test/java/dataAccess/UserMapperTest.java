package dataAccess;

import models.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-19:08
 */

public class UserMapperTest {


    @Test
    void create() {
        User user = new User("Stone", "1234");
        UserMapper.createUser(user);
    }

    @Test
    void createUserTest(){
        User user = new User("root","5314");
        User userFound = UserMapper.readUserByUserName(user.getUserName());
        // delete the old one
        if (userFound != null){
            UserMapper.deleteUser(userFound);
        }
        // create a new one
        UserMapper.createUser(user);
        // find all
        ArrayList<User> users = UserMapper.readAllUsers();
        for (User someUser: users){
            System.out.println(someUser);
        }

        // test password
        userFound = UserMapper.readUserByUserName(user.getUserName());
        System.out.println(userFound.getPassword());

    }

}
