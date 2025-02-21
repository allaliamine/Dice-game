package org.app.dicegame.web.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DeconnectServlet", urlPatterns = "/deconnect")
public class DeconnectServlet extends HttpServlet {

    /*
    * Used to Log out
    */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession sess = req.getSession();
        // destruct the session
        sess.invalidate();

        // redirect to index.jsp
        resp.sendRedirect(req.getContextPath() + "/");
    }


}
