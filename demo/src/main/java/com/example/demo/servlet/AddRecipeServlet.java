package com.example.demo.servlet;

import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(urlPatterns = "/secured/add-recipe")
public class AddRecipeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request
                .getRequestDispatcher("/WEB-INF/add-recipe-form.jsp")
                .forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String pictureUrl = req.getParameter("pictureUrl");
        String category = req.getParameter("category");
        new RecipeService().createRecipe(new Recipe(title, content, pictureUrl, category));
        resp.sendRedirect("recipes");
    }
}
