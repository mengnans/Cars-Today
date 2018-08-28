package utils;

import org.junit.jupiter.api.Test;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-23:17
 */

public class UtilsTest {

    @Test
    void testMd5(){
        String pwd = "5314";
        String encryptedPwd = Utils.getMd5(pwd);
        System.out.println(encryptedPwd);
        String pwd2 = "5314";
        String encryptedPwd2 = Utils.getMd5(pwd2);
        assert encryptedPwd.equals(encryptedPwd2);
    }

}
