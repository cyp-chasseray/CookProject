package com.example.demo.DAO;
import com.example.demo.model.User;
import com.example.demo.service.RecipeService;
import com.example.demo.service.UserService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RecipeService recipeService = new RecipeService();
        System.out.println(recipeService.fetchAllRecipes());
    }
}
