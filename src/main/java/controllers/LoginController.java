package controllers;

import dataAccess.UserMapper;
import models.User;
import utils.AuthenticationEnforcer;
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
        if (userIdInSession != null) {
            forward("/home", req, resp);
        } else {
            forward("/login.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String pwd = req.getParameter("password");

        long _id = AuthenticationEnforcer.VerifyUser(userName, pwd);
        if (_id != -1) {
            HttpSession session = req.getSession();
            session.setAttribute("userId", _id);
            session.setAttribute("userName", userName);
            forward("/home", req, resp);
        } else {
            req.setAttribute("error", "Incorrect username or password");
            forward("/error.jsp", req, resp);
        }
    }
}