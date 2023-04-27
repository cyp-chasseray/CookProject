package com.example.demo.service;

import com.example.demo.DAO.RecipeDAO;
import com.example.demo.DAO.UsedRecipeDAO;
import com.example.demo.model.Recipe;
import com.example.demo.model.UsedRecipe;

import java.util.List;

public class UsedRecipeService {
    private UsedRecipeDAO usedRecipeDAO = new UsedRecipeDAO();
    public UsedRecipe createUsedRecipe(UsedRecipe usedRecipe) {

        return usedRecipeDAO.create(usedRecipe);
    }

    public List<UsedRecipe> fetchAllByTitleAndEmail(String title, String email) {
        return usedRecipeDAO.fetchAllByTitleAndEmail(title, email);
    }
}
