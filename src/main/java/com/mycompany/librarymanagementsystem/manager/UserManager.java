/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.manager;
import com.mycompany.librarymanagementsystem.db.DatabaseConnection;
import com.mycompany.librarymanagementsystem.model.User;
import com.mycompany.librarymanagementsystem.UserOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author francescosciabbarrasi
 */
public class UserManager implements UserOperations {
    private final Connection db;
    
    public UserManager() {
        this.db = DatabaseConnection.getInstance().getConnection();
    }
    
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO Users (name, role, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getRole());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.executeUpdate();
            System.out.println("User added: " + user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateUser(User user) {
        String sql = "UPDATE Users SET name = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getId());
            pstmt.executeUpdate();
            System.out.println("User updated: " + user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deleteUser(int userId) {
        String sql = "DELETE FROM Users WHERE id = ?";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
            System.out.println("User deleted with ID: " + userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public User findUser(int userId) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("role"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
