package com.example.demo.DAO;

import com.example.demo.connexion.ConnexionManager;
import com.example.demo.model.UsedRecipe;
import com.example.demo.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class UsedRecipeDAO implements GenericDAO<UsedRecipe> {
    Connection connection = ConnexionManager.getINSTANCE();
    @Override
    public UsedRecipe create(UsedRecipe usedRecipe) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO usedrecipes (email, recipeTitle, creationDate) VALUES (?, ?, ?);")) {
            statement.setString(1, usedRecipe.getEmail());
            statement.setString(2, usedRecipe.getRecipeTitle());
            statement.setDate(3, usedRecipe.getCreationDate());
            statement.executeUpdate();
            return usedRecipe;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UsedRecipe> fetchAll() {
        return null;
    }

    @Override
    public UsedRecipe fetchOne(int id) {
        return null;
    }

    public List<UsedRecipe> fetchAllByTitleAndEmail(String title, String email) {
        List<UsedRecipe> listUsedRecipe = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT email, recipeTitle, creationDate FROM usedrecipes WHERE email = ? AND recipeTitle = ?");
        ) {
            statement.setString(1, email);
            statement.setString(2, title);
            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    // Convert java.sql.Date to java.time.LocalDate
                    LocalDate creationDate = results.getDate("creationDate").toLocalDate();
                    LocalDate currentDate = LocalDate.now();
                    Date date = Date.valueOf(currentDate);
                    long diffInDays = ChronoUnit.DAYS.between(creationDate, currentDate);
                    if (diffInDays > 6L) {
                        listUsedRecipe.add(new UsedRecipe(
                                results.getString("email"),
                                results.getString("recipeTitle"),
                                date
                        ));
                    }
                }
                return listUsedRecipe;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, UsedRecipe object) {

    }

    @Override
    public void delete(int id) {

    }
}