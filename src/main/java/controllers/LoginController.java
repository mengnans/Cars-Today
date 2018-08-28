package controllers;

import dataAccess.UserMapper;
import models.User;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-17:44
 */

@WebServlet("/login")
public class LoginController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        // find the user from database
        User user = UserMapper.readUserByUserName(userName);

        // if find such user
        if (user != null) {
            String pwd = req.getParameter("password");
            String encryptedPwd = Utils.getMd5(pwd);
            // correct password
            if (encryptedPwd != null && encryptedPwd.equals(user.getPassword())){
                // navigate to home page
                req.setAttribute("userId", user.getUid());
                req.setAttribute("userName", user.getUserName());
                forward("/home.jsp", req, resp);
                return;
            }
        }

        // otherwise
        req.setAttribute("error","Incorrect username or password");
        forward("/error.jsp", req, resp);

    }
}
