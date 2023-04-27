package com.example.demo.service;
import com.example.demo.DAO.RecipeDAO;
import com.example.demo.model.Recipe;

import java.util.List;

public class RecipeService {
    private RecipeDAO recipeDAO = new RecipeDAO();
    public List<Recipe> fetchAllRecipes() {
        return recipeDAO.fetchAll();
    }

    public Recipe fetchOneRecipe(int id) {

        return recipeDAO.fetchOne(id);
    }

    public Recipe createRecipe(Recipe recipe) {

        return recipeDAO.create(recipe);
    }

    public void deleteRecipe(int id) {

        recipeDAO.delete(id);
    }

    public void updateRecipe(int id, Recipe r) {

        recipeDAO.update(id, r);
    }

    public void setRecipeDAO(RecipeDAO recipeDAO) {

        this.recipeDAO = recipeDAO;
    }

}


