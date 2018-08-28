package controllers;

import dataAccess.AdminMapper;
import models.Administrator;
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

@WebServlet("/admin/login")
public class AdminLoginController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        // find the user from database
        Administrator admin = AdminMapper.readAdminByAdminName(adminName);

        // if find such user
        if (admin != null) {
            String pwd = req.getParameter("password");
            String encryptedPwd = Utils.getMd5(pwd);
            // correct password
            if (encryptedPwd != null && encryptedPwd.equals(admin.getPassword())){
                // navigate to home page
                req.setAttribute("adminId", admin.getAid());
                req.setAttribute("adminName", adminName);
                forward("/admin/home.jsp", req, resp);
                return;
            }
        }

        // otherwise
        req.setAttribute("error","Incorrect username or password");
        forward("/admin/error.jsp", req, resp);

    }
}