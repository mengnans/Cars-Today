package controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mengnan Shi
 * @create 2018-08-27-18:07
 */

public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void forward (String target, HttpServletRequest request,
                           HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }
}
