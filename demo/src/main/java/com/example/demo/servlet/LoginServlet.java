package com.example.demo.servlet;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User currentUser = new UserDAO().fetchOneByEmail(email);
        if (currentUser.getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", currentUser.getEmail());
            resp.sendRedirect(req.getContextPath() + "/secured");
        } else {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
        }
    }
}

