package com.example.demo.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionManager {
    private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/cookapi";
    private static final String USER = "root";
    private static final String PASSWORD = "4900Mysql!";
    private static Connection INSTANCE;
    private ConnexionManager() {
    }
    public static Connection getINSTANCE() {
        if (INSTANCE == null) {
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                INSTANCE = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }
        return INSTANCE;
    }
    public static void CloseConnection() throws SQLException {
        if (INSTANCE!= null && !INSTANCE.isClosed()) {
            INSTANCE.close();
        }
    }

}

