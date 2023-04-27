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
                "INSERT INTO users (username, password) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
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
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, username, password FROM users");
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                listUser.add(new User(
                        results.getInt("id"),
                        results.getString("username"),
                        results.getString("password")
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
        try (PreparedStatement statement = connection.prepareStatement("SELECT id, username, password FROM users WHERE users.id = ?;")) {
            statement.setInt(1, idUser);
            try (ResultSet results = statement.executeQuery()) {
                if (results.next()) {
                    user = (new User(
                            results.getInt("id"),
                            results.getString("username"),
                            results.getString("password")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void update(int id, User user) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE users SET id = ?, username = ?, password = ? WHERE id = ?;")) {
            statement.setInt(1, id);
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override

    public void delete(int id) {
        try (
                PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
