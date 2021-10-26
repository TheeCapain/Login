package com.example.login.DBManager;

import java.sql.*;

public class DBManager {
    static Connection connect;

    public Connection setConnection() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "August", "x");
            System.out.println("Connection set");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connect;
    }


}



