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
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/connect")
public class ConnectionServlet extends HttpServlet {

    /*
    * getting the email and password from the form to sign in
    * and initializing the game stats
    */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        ServletContext con = req.getServletContext();

        List<User> list = (List<User>) con.getAttribute("users");

        if(password != null && email != null && list != null){

            User LoggedUser = new User(email, password);

            for(User usr: list){

                if(usr.equals(LoggedUser)){

                    HttpSession sess = req.getSession();

                    ConnectionServlet conn = new ConnectionServlet();
                    conn.initialise(sess);
                    sess.setAttribute("user", usr);

                    req.getRequestDispatcher("/WEB-INF/view/homePage.jsp").forward(req,resp);
                    return;
                }
            }
        }

        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }

    /*
    * this method call the initialise method when the user want to reset or re-start the game
    */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            String action = req.getParameter("action");

            if(action!= null && action.equals("re-init")){
                HttpSession sess = req.getSession();

                ConnectionServlet conn = new ConnectionServlet();
                conn.initialise(sess);

            }

            req.getRequestDispatcher("/WEB-INF/view/homePage.jsp").forward(req,resp);


    }


    /*
     * method to initialise the session attributes when the user finish the game
     * (can be also used even in the middle of the game)
     */
    public void initialise(HttpSession sess){

        int throwsNumber = 20;
        int score = 0;

        LinkedList<Integer> throwHistory = new LinkedList<>();
        sess.setAttribute("throwsNumber", throwsNumber);
        sess.setAttribute("throwHistory",throwHistory);
        sess.setAttribute("score",score);

    }

}
