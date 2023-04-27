package com.example.demo.DAO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        List<User> list = userService.fetchAllUsers();
        System.out.println(list);
    }
}
