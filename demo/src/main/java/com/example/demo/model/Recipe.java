package com.example.demo.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Recipe {
    private int id;
    private String title;
    private String content;
    private String pictureUrl;
    private String category;

    public Recipe(int id, String title, String content, String pictureUrl, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pictureUrl = pictureUrl;
        this.category = category;
    }

    public Recipe(String title, String content, String pictureUrl, String category) {
        this.title = title;
        this.content = content;
        this.pictureUrl = pictureUrl;
        this.category = category;
    }

    public static List<Recipe> randomRecipe(List<Recipe> recipeList) {
        Random rand = new Random();
        Recipe randomRecipe = recipeList.get(rand.nextInt(recipeList.size()));
        return Collections.singletonList(randomRecipe);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
