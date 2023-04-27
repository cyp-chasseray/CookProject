package com.example.demo.DAO;
import com.example.demo.model.UsedRecipe;
import com.example.demo.model.User;
import com.example.demo.service.RecipeService;
import com.example.demo.service.UserService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UsedRecipeDAO usedRecipeDAO = new UsedRecipeDAO();
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        usedRecipeDAO.create(new UsedRecipe("cyp@cyp", "titletest", date));
    }
}
