package com.example.demo.service;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    public List<User> fetchAllUsers() {
        return userDAO.fetchAll();
    }

    public User fetchOneUser(int id) {
        return userDAO.fetchOne(id);
    }

    public User fetchOneUserByEmail(String email) {
        return userDAO.fetchOneByEmail(email);
    }

    public User createUser(User user) {
        return userDAO.create(user);
    }

    public void deleteUser(int id) {

        userDAO.delete(id);
    }

    public void updateUser(int id, User r) {

        userDAO.update(id, r);
    }

    public void setUserDAO(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

}


