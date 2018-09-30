package utils;

import dataAccess.AdminMapper;
import dataAccess.UserMapper;
import models.Administrator;
import models.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import javax.servlet.http.HttpSession;

public class AuthenticationEnforcer {

    public static boolean VerifyAdmin(String argUsername, String argPsw) {
//        Administrator admin = AdminMapper.readAdminByAdminName(argUsername);
//        if (admin != null) {
//            String encryptedPwd = Utils.getMd5(argPsw);
//            return encryptedPwd != null && encryptedPwd.equals(admin.getPassword());
//        }
//        return false;


// This is the Shiro version of verifying. I tried my best to make it work but failed
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(argUsername, argPsw);
        try {
            currentUser.login(token);
            return true;
        } catch (Exception uae) {
            return false;
        }
    }

    public static long VerifyUser(String argUsername, String argPsw) {
        if (argUsername == null || argUsername.equals("")) return -1;

        // find the user from database
        User user = UserMapper.readUserByUserName(argUsername);

        // if find such user
        if (user != null) {
            String encryptedPwd = Utils.getMd5(argPsw);
            // correct password
            if (encryptedPwd != null && encryptedPwd.equals(user.getPassword())) {
                return user.getUid();
            } ;
        }
        return -1;
    }


}
