package com.example.demo.servlet;

import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = {"/", "/recipes"})
public class RecipesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeService();
        List<Recipe> recipeList= recipeService.fetchAllRecipes();
        req.setAttribute("recipes", recipeList);
        req.getRequestDispatcher("/WEB-INF/recipe-list.jsp").forward(req, resp);
    }
}
