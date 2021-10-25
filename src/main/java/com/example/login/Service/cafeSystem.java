package com.example.login.Service;

import com.example.login.Model.User;

import java.sql.*;

public class cafeSystem {
    static Connection connect;
    public void setConnection() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe", "August", "x");
            System.out.println("Connection set");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public User tryLogin(String username, String password) {
        User u = null;
        try {
            PreparedStatement ps;
            String query = "SELECT * FROM customer where username = ? and password = ?";
            ps = connect.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            //Resultset kører igennem databasen
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                u = new User(rs.getString(2), rs.getString(3));
            }
        } catch (SQLException err) {
            System.out.println(err + "User does not exist");
        }
        return u;
    }

    public void addUser(String name, String pw) {
        String SQL = "INSERT INTO customer(username, password) values (? ,?)";
        try {
            PreparedStatement ps = connect.prepareStatement(SQL);
            ps.setString(1, name);
            ps.setString(2, pw);
            ps.executeUpdate();

        } catch (SQLException err) {
            System.out.println(err + "Could not add user");
        }

    }
}



