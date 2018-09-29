package controllers.admin;

import controllers.MyServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-17:45
 */

@WebServlet("/admin/logout")
public class AdminLogoutController extends MyServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("adminName");
        session.removeAttribute("adminId");
        forward("/admin/login",req,resp);
    }

}
