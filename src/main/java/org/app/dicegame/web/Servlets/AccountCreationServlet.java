package org.app.dicegame.web.Servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.app.dicegame.Classes.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/register")
public class AccountCreationServlet extends HttpServlet {

    /*
     * getting the information from the form in order to create the account for the user
     * Questioning ? even if I check if params aren't null password sometimes can be empty and still manage to pass the check
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String lastName = req.getParameter("last_name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");


        HttpSession sess = req.getSession();
        String message ;

        ServletContext conn = req.getServletContext();

        List<User> list = (List<User>) conn.getAttribute("users") ;

        if (list == null){
            list = new ArrayList<>();
        }

        if(name != null && lastName != null && password != null && email != null && !(password.trim()).isEmpty()){

            User usr = new User(name, lastName, email, password, 0);

            list.add(usr);

            conn.setAttribute("users", list);
            message = "Account created with success You can Log in now!! :)";
            sess.setAttribute("message", message);
            resp.sendRedirect(req.getContextPath()+"/");

        }else{
            message = "Couldn't create account please retry";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/view/registerPage.jsp").forward(req, resp);
        }
    }

    /*
     * this method is created so that when the user refresh the page it stays at the /register
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/registerPage.jsp").forward(req,resp);
    }
}
