package utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-23:17
 */

public class ShiroTest {

    @Test
    void testShiro() throws IOException {
        boolean _result = AuthenticationEnforcer.VerifyAdmin("root", "5314r6iu5r76");
        System.out.println(_result);
    }

}
