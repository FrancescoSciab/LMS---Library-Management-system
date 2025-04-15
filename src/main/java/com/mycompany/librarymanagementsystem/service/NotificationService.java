/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.service;
import com.mycompany.librarymanagementsystem.manager.UserManager;
import com.mycompany.librarymanagementsystem.manager.TransactionManager;
import com.mycompany.librarymanagementsystem.model.Transaction;
import com.mycompany.librarymanagementsystem.model.User;
import com.mycompany.librarymanagementsystem.factory.UserFactory;
import com.mycompany.librarymanagementsystem.db.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author francescosciabbarrasi
 */
public class NotificationService {
    private final Connection db;
    
    public NotificationService() {
        this.db = DatabaseConnection.getInstance().getConnection();
    }
    
    public void checkDueBooks() {
        LocalDate today = LocalDate.now();
        int dueDays = 14; // Books are due after 14 days
        boolean hasNotifications = false; // Flag to track notifications

        String sql = """
            SELECT t.transactionId, t.bookId, t.userId, t.issueDate, u.name, u.role, u.email, u.password
            FROM Transactions t
            JOIN Users u ON t.userId = u.id
            WHERE t.status = 'Issued'
            AND t.issueDate <= ?
        """;

        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            //set the date to 14 days ago
            pstmt.setObject(1, today.minusDays(dueDays));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LocalDate issueDate = rs.getObject("issueDate", LocalDate.class);
                LocalDate dueDate = issueDate.plusDays(dueDays);

                // Createing User object using UserFactory
                User user = UserFactory.createUser(
                    rs.getInt("userId"),
                    rs.getString("name"),
                    rs.getString("role"),
                    rs.getString("email"),
                    rs.getString("password")
                );

                // Notify based on due status and availability
                if (today.isAfter(dueDate)) {
                    String message = "Book ID " + rs.getInt("bookId") + " is overdue! Due date was " + dueDate;
                    user.receiveNotification(message);
                    hasNotifications = true;
                } else if (today.equals(dueDate)) {
                    String message = "Book ID " + rs.getInt("bookId") + " is due today!";
                    user.receiveNotification(message);
                    hasNotifications = true;
                } 
            }
            if (!hasNotifications) {
                System.out.println("No books are due or overdue.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
}
