package com.example.demo.DAO;

import com.example.demo.connexion.ConnexionManager;
import com.example.demo.model.Recipe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO implements GenericDAO<Recipe> {
    Connection connection = ConnexionManager.getINSTANCE();

    @Override
        public Recipe create(Recipe recipe) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO recipes (title, content, pictureurl, category) VALUES (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, recipe.getTitle());
                statement.setString(2, recipe.getContent());
                statement.setString(3, recipe.getPictureUrl());
                statement.setString(4, recipe.getCategory());
                statement.executeUpdate();
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        recipe.setId(generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating recipe failed, no ID obtained.");
                    }
                }
                return recipe;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
    public List<Recipe> fetchAll() {
        List<Recipe> listRecipe = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, title, content, pictureurl, category FROM recipes");
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                listRecipe.add(new Recipe(
                        results.getInt("id"),
                        results.getString("title"),
                        results.getString("content"),
                        results.getString("pictureurl"),
                        results.getString("category")
                ));
            }
            return listRecipe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Recipe fetchOne(int idRecipe) {
        Recipe recipe = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, title, content, pictureUrl, category FROM recipes WHERE recipes.id = ?;")) {
            statement.setInt(1, idRecipe);
            try (ResultSet results = statement.executeQuery()) {
                if (results.next()) {
                    recipe = (new Recipe(
                            results.getInt("id"),
                            results.getString("title"),
                            results.getString("content"),
                            results.getString("pictureurl"),
                            results.getString("category")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipe;
    }

    public List<Recipe> fetchByKeyWord(String keyword) {
        List<Recipe> listRecipe = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, title, content, pictureUrl, category FROM recipes WHERE category LIKE ? OR content LIKE ?;");
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                listRecipe.add(new Recipe(
                        results.getInt("id"),
                        results.getString("title"),
                        results.getString("content"),
                        results.getString("pictureUrl"),
                        results.getString("category")));
            }
            return listRecipe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(int id, Recipe recipe) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE recipes SET id = ?, title = ?, content = ?, pictureUrl = ?, category = ? WHERE id = ?;")) {
            statement.setInt(1, id);
            statement.setString(2, recipe.getTitle());
            statement.setString(3, recipe.getContent());
            statement.setString(4, recipe.getPictureUrl());
            statement.setString(5, recipe.getCategory());
            statement.setInt(6, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public void delete(int id) {
        try (
                PreparedStatement statement = connection.prepareStatement("DELETE FROM recipes WHERE id = ?;")) {
                statement.setInt(1, id);
                statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
