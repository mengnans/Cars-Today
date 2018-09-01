package controllers;

import dataAccess.UserMapper;
import models.User;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-17:44
 */

@WebServlet("/login")
public class LoginController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object userIdInSession = session.getAttribute("userId");
        if (userIdInSession != null ){
            forward("/home", req, resp);
        } else {
            forward("/login.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");

        if (userName == null){
            forward("/login.jsp", req, resp);
        }

        // find the user from database
        User user = UserMapper.readUserByUserName(userName);

        // if find such user
        if (user != null) {
            String pwd = req.getParameter("password");
            String encryptedPwd = Utils.getMd5(pwd);
            // correct password
            if (encryptedPwd != null && encryptedPwd.equals(user.getPassword())){
                HttpSession session = req.getSession();
                // we are setting userId and userName as session
                // so before the user closes the browser or delete
                // the session, we don't need to search the user
                // table again.
                session.setAttribute("userId", user.getUid());
                session.setAttribute("userName", user.getUserName());
                // navigate to home page
                forward("/home", req, resp);
                return;
            }
        }

        // otherwise
        req.setAttribute("error","Incorrect username or password");
        forward("/error.jsp", req, resp);

    }
}
