package com.example.demo.servlet;

import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {"/secured", "/secured/recipes"})
public class SecuredRecipesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeService();
        String mealChoice = req.getParameter("mealChoice");
        String keyword = req.getParameter("keyword");
        List<Recipe> recipeList;

        if (mealChoice != null && (mealChoice.equals("Breakfast") || mealChoice.equals("Diner") || mealChoice.equals("Lunch") ||
                mealChoice.equals("breakfast") || mealChoice.equals("diner") || mealChoice.equals("lunch"))) {
            recipeList = Recipe.randomRecipe(recipeService.fetchRecipeByKeyWord(mealChoice));

        } else if (mealChoice != null) {
            recipeList = null;

        }else if (keyword!= null) {
            recipeList = recipeService.fetchRecipeByKeyWord(keyword);

        } else {
            recipeList = recipeService.fetchAllRecipes();
        }

        req.setAttribute("recipes", recipeList);
        req.getRequestDispatcher("/WEB-INF/recipe-list-secured.jsp").forward(req, resp);
    }
}
