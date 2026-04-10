package com.learninglog.learninglogproject.user.controller;

import com.learninglog.learninglogproject.user.model.dao.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name="registerPage", value = "/register")

public class RegisterServlet extends HttpServlet {
    // for handling the get request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/register.jsp");

            String message = "Please fill all the required fields";
            request.setAttribute("error", message);
            requestDispatcher.forward(request, response);
        }

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try{
            UserDao userDao = new UserDao();
            System.out.println(username+email+ password);
            System.out.println("name+email+ password");
            boolean userInserted = userDao.insertUser(username,email,hashedPassword);

            if (userInserted){
                request.getRequestDispatcher("pages/login.jsp").forward(request,response);
            }else{
                request.setAttribute("error","something went wrong ! Please try again");
                request.getRequestDispatcher("pages/register.jsp").forward(request,response);
            }
        }
        catch (Exception e ){
            request.setAttribute("error",e.getMessage());
            request.getRequestDispatcher("pages/register.jsp").forward(request,response);

        }

    }
}
