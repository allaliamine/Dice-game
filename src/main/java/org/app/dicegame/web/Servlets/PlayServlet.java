package org.app.dicegame.web.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.app.dicegame.Classes.User;

import java.io.IOException;
import java.util.LinkedList;

import static org.app.dicegame.Classes.Generator.generateNumber;

@WebServlet(urlPatterns = "/play")
public class PlayServlet extends HttpServlet {

    /*
    * this method is triggered when the user start playing (roll the dice)
    * it updates the score and best score.
    */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession sess = req.getSession();

        LinkedList<Integer> throwHistory = (LinkedList<Integer>) sess.getAttribute("throwHistory");
        int throwsNumber = (Integer) sess.getAttribute("throwsNumber");
        int score = (Integer) sess.getAttribute("score");

        int result = generateNumber();

        if (!throwHistory.isEmpty()) {
            int lastThrow = throwHistory.getLast();
            if(result == lastThrow){
                score += 20;
            }
        }

        throwHistory.add(result);

        --throwsNumber;

        sess.setAttribute("score", score);
        sess.setAttribute("throwsNumber",throwsNumber);

        User loggedUser = (User) sess.getAttribute("user");

        if(loggedUser.getBestScore() < score){
            ((User) sess.getAttribute("user")).setBestScore(score);
        }

        req.getRequestDispatcher("/WEB-INF/view/homePage.jsp").forward(req, resp);
    }

}