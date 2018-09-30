package controllers.admin;

import controllers.MyServlet;
import org.apache.shiro.authc.*;
import utils.AuthenticationEnforcer;

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
        if (adminIdInSession != null) {
            forward("/admin/home", req, resp);
        } else {
            forward("/admin/login.jsp", req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminName = req.getParameter("adminName");
        String pwd = req.getParameter("password");

        boolean _isSuccess =  AuthenticationEnforcer.VerifyAdmin(adminName, pwd);

        if (_isSuccess) {
            HttpSession session = req.getSession();
            session.setAttribute("adminId", adminName);
            session.setAttribute("adminName", adminName);
            forward("/admin/home", req, resp);
        } else {
            req.setAttribute("error", "Incorrect username or password");
            forward("/admin/error.jsp", req, resp);

        }
    }
}