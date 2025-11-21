package com.store.fresh_fold.DAO;

import com.store.fresh_fold.Model.User;
import com.store.fresh_fold.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class  UserDAO {

    // check user login
    public boolean checkUser(String userName, String password) {
        String sql = "SELECT * FROM users WHERE userName = ? AND password= ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean createUser (User user) {
        Connection conn = DBConnect.getConnection();

        try {
            String sql = "INSERT INTO users (firstName, lastName, userName, password, email, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getUserName());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getPhoneNumber());

            stmt.executeUpdate();
            System.out.println("User created successfully!");
            return true;

    } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // new method to get users by  userName
    public User getUserByUserName(String userName) {
        String sql = "SELECT * FROM users WHERE userName = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhoneNumber(rs.getString("phoneNumber"));
                return user;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return null;
    }



}
