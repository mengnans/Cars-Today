package dataaccess;

import domain.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mengnan Shi
 * @create 2018-08-21-19:08
 */

public class UserMapperTest {

    private static UserMapper userMapper;

    static {
        userMapper = new UserMapper();
    }

    @Test
    void createUserTest(){
        User user = new User("root","5314");
        User userFound = userMapper.readUserByUserName(user.getUserName());
        // delete the old one
        if (userFound != null){
            userMapper.deleteUser(userFound);
        }
        // create a new one
        userMapper.createUser(user);
        // find all
        ArrayList<User> users = userMapper.readAllUsers();
        for (User someUser: users){
            System.out.println(someUser);
        }
    }

}
