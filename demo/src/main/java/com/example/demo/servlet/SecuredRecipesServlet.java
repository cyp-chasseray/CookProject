package com.example.demo.servlet;

import com.example.demo.model.Recipe;
import com.example.demo.model.UsedRecipe;
import com.example.demo.service.RecipeService;
import com.example.demo.service.UsedRecipeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
@WebServlet(urlPatterns = {"/secured", "/secured/recipes"})
public class SecuredRecipesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RecipeService recipeService = new RecipeService();
//        UsedRecipeService usedRecipeService = new UsedRecipeService();
        String mealChoice = req.getParameter("mealChoice");
        String keyword = req.getParameter("keyword");
        List<Recipe> recipeList;

        if (mealChoice != null && (mealChoice.equals("Breakfast") || mealChoice.equals("Diner") || mealChoice.equals("Lunch") ||
                mealChoice.equals("breakfast") || mealChoice.equals("diner") || mealChoice.equals("lunch"))) {
            List<Recipe> tempList = recipeService.fetchRecipeByKeyWord(mealChoice);
            recipeList = Recipe.randomRecipe(tempList);
//
//            // The code above works, below is the draft for the 6 days condition

//            HttpSession session = req.getSession();
//
//            // check if this recipe title is in the SQL database associated with email and if less than 6 days old
//
//            List<UsedRecipe> matchingUsedRecipes = usedRecipeService
//                    .fetchAllByTitleAndEmail(
//                            recipeList.get(0).getTitle(),
//                            session.getAttribute("username").toString());
//
//            if (matchingUsedRecipes.isEmpty()) {
//            //create row in SQL Table userRecipes with email, recipe title and datetime
//            LocalDate localDate = LocalDate.now();
//            Date date = Date.valueOf(localDate);
//            usedRecipeService.createUsedRecipe(new UsedRecipe(
//                    session.getAttribute("username").toString(),
//                    recipeList.get(0).getTitle(),
//                    date));
//            }
//            // if yes, update templist by popping the recipe
//            // check if templist is not null. If null return it
//            // if not null start over

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
