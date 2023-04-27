package com.example.demo.model;

import java.util.Date;

public class UsedRecipe {
    private String email;
    private String recipeTitle;
    private java.sql.Date creationDate;

    public UsedRecipe(String email, String recipeTitle, java.sql.Date creationDate) {
        this.email = email;
        this.recipeTitle = recipeTitle;
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public void setRecipeTitle(String recipeTitle) {
        this.recipeTitle = recipeTitle;
    }

    public java.sql.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.sql.Date creationDate) {
        this.creationDate = creationDate;
    }
}

