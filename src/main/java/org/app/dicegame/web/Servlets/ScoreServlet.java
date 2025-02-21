package org.app.dicegame.web.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.dicegame.Classes.User;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(urlPatterns = "/scoreTable")
public class ScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> users = (List<User>) request.getServletContext().getAttribute("users");

        //sort the liste based on best score
        users.sort(Comparator.comparing(User::getBestScore).reversed());

        request.setAttribute("sortedUsers", users);

        request.getRequestDispatcher("/WEB-INF/view/scoreTable.jsp").forward(request,response);

    }

}