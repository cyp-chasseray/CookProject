package com.example.demo.DAO;

import com.example.demo.connexion.ConnexionManager;
import com.example.demo.model.Recipe;
import com.example.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements GenericDAO<User> {
    Connection connection = ConnexionManager.getINSTANCE();

    @Override
    public User create(User user) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO users (firstname, password, lastname, email, pictureUrl) VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getLastname());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPictureUrl());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating recipe failed, no ID obtained.");
                }
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> fetchAll() {
        List<User> listUser = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, firstname, password, lastname, email, pictureUrl FROM users");
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                listUser.add(new User(
                        results.getInt("id"),
                        results.getString("lastname"),
                        results.getString("firstname"),
                        results.getString("pictureUrl"),
                        results.getString("password"),
                        results.getString("email")
                ));
            }
            return listUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User fetchOne(int idUser) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, lastname, firstname, password, email, pictureurl FROM users WHERE users.id = ?;")) {
            statement.setInt(1, idUser);
            try (ResultSet results = statement.executeQuery()) {
                if (results.next()) {
                    user = (new User(
                            results.getInt("id"),
                            results.getString("lastname"),
                            results.getString("firstname"),
                            results.getString("pictureUrl"),
                            results.getString("password"),
                            results.getString("email")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public User fetchOneByEmail(String email) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, lastname, firstname, password, email, pictureurl FROM users WHERE email = ?;");
            statement.setString(1, email);
            ResultSet results = statement.executeQuery();

            if (results.next()) {
                user = (new User(
                        results.getInt("id"),
                        results.getString("lastname"),
                        results.getString("firstname"),
                        results.getString("pictureUrl"),
                        results.getString("password"),
                        results.getString("email")
                )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    @Override
    public void update(int id, User user) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE users SET id=?, lastname=?, firstname=?, pictureUrl = ?, password=?, email=?, password = ? WHERE id = ?;")) {
            statement.setInt(1, id);
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getFirstname());
            statement.setString(4, user.getPictureUrl());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getEmail());
            statement.setInt(7, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public void delete(int id) {
//        try (
//                PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {
//            statement.setInt(1, id);
//            statement.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
}
