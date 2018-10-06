package utils;

import dataAccess.UserMapper;
import models.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.jdbc.JdbcRealm;

public class AppRealm extends JdbcRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken _token = (UsernamePasswordToken) token;
        String _username = _token.getUsername();
        if (_username.equals("root")) {
            return new SimpleAuthenticationInfo("root", "5314", "Admin");
        } else {
            User _user = UserMapper.readUserByUserName(_username);
            if (_user == null) return null;
            return new SimpleAuthenticationInfo(_username, _user.getPassword(), "user");
        }
    }
}