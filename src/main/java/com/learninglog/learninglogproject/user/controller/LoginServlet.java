package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.user.model.dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    @Override
    protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/login.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            UserDao dao = new UserDao();
            User userObj = dao.loginUser(email, password);
            if (userObj != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userObj);
                response.sendRedirect("/dashboard");
            } else {
                request.setAttribute("error", "Invalid Username or Password");
                request.getRequestDispatcher("pages/login.jsp").forward(request, response);
            }

        } catch (Exception e){
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("pages/login.jsp").forward(request, response);
        }
    }
}
