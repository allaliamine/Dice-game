package org.app.dicegame.web.Filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SignInChecker implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession sess = req.getSession();

        if(sess.getAttribute("user") == null){
            req.getRequestDispatcher("/").forward(servletRequest,servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
