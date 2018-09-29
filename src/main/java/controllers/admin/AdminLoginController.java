package controllers.admin;

import controllers.MyServlet;
import dataAccess.AdminMapper;
import models.Administrator;
import utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-17:44
 */

@WebServlet("/admin/login")
public class AdminLoginController extends MyServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object adminIdInSession = session.getAttribute("adminId");
        if (adminIdInSession != null ){
            forward("/admin/home", req, resp);
        } else {
            forward("/admin/login.jsp", req, resp);
        }
    }

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
                HttpSession session = req.getSession();
                session.setAttribute("adminId", admin.getAid());
                session.setAttribute("adminName", admin.getAdminName());
                forward("/admin/home", req, resp);
                return;
            }
        }

        // otherwise
        req.setAttribute("error","Incorrect username or password");
        forward("/admin/error.jsp", req, resp);

    }
}
