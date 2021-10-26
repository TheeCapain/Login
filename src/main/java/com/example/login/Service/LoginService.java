package com.example.login.Service;

import com.example.login.DBManager.DBManager;
import com.example.login.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {
    DBManager system = new DBManager();
     Connection connect = system.setConnection();

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
            System.out.println("User added");

        } catch (SQLException err) {
            System.out.println(err + "Could not add user");
        }

    }
}
