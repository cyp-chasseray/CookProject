package com.example.demo.servlet;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("lastname");
        String lastname = req.getParameter("firstname");
        String pictureUrl = req.getParameter("pictureUrl");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (password.equals(confirmPassword)) {
            new UserService().createUser(new User(firstname, lastname, pictureUrl, password, email));
            req.getRequestDispatcher("/WEB-INF/inscriptionConfirmation.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
        }
    }
}


