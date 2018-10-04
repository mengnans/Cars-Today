package utils;

import dataAccess.UserMapper;
import models.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;

public class AuthenticationEnforcer {

    public static boolean VerifyAdmin(String argUsername, String argPsw) {
// This is the second version of Shiro
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(argUsername, argPsw);
        try {
            currentUser.login(token);
            return true;
        } catch (Exception uae) {
            return false;
        }


// This is the Shiro version of verifying. I tried my best to make it work but failed
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("shiro.ini");
//        SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);
//        Subject currentUser = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(argUsername, argPsw);
//        try {
//            currentUser.login(token);
//            return true;
//        } catch (Exception uae) {
//            return false;
//        }

// This is the original code used for login
//        Administrator admin = AdminMapper.readAdminByAdminName(argUsername);
//        if (admin != null) {
//            String encryptedPwd = Utils.getMd5(argPsw);
//            return encryptedPwd != null && encryptedPwd.equals(admin.getPassword());
//        }
//        return false;
    }

    public static long VerifyUser(String argUsername, String argPsw) {
        if (argUsername == null || argUsername.equals("")) return -1;

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(argUsername, Utils.getMd5(argPsw));
        try {
            currentUser.login(token);
            User user = UserMapper.readUserByUserName(argUsername);
            return user.getUid();
        } catch (Exception uae) {
            return -1;
        }

// This is the original version of login
//        // find the user from database
//        User user = UserMapper.readUserByUserName(argUsername);
//
//        // if find such user
//        if (user != null) {
//            String encryptedPwd = Utils.getMd5(argPsw);
//            // correct password
//            if (encryptedPwd != null && encryptedPwd.equals(user.getPassword())) {
//                return user.getUid();
//            }
//        }
//        return -1;
    }


}
