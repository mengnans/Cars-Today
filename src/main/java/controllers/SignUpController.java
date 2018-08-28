package controllers;

import dataAccess.UserMapper;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-17:44
 */

@WebServlet("/sign-up")
public class SignUpController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        // find the user from database
        User user = UserMapper.readUserByUserName(userName);

        // if didn't find such user
        if (user == null) {
            String pwd = req.getParameter("password");
            String repeatPwd = req.getParameter("repeatPassword");
            if (pwd != null && pwd.equals(repeatPwd)){
                User newUser = new User(userName, pwd);
                UserMapper.createUser(newUser);
                forward("/login.jsp", req, resp);
            } else {
                req.setAttribute("error","Incorrect password");
                forward("/error.jsp", req, resp);
            }
        } else {
            req.setAttribute("error","The username exists in our database");
            forward("/error.jsp", req, resp);
        }



    }
}
