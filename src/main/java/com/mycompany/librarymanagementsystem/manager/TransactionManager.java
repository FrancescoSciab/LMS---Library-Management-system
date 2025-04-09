/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.manager;
import com.mycompany.librarymanagementsystem.model.Book;
import com.mycompany.librarymanagementsystem.model.Transaction;
import com.mycompany.librarymanagementsystem.model.User;
import com.mycompany.librarymanagementsystem.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francescosciabbarrasi
 */
public class TransactionManager {
    private final Connection db;
    private final BookManager bookManager;
    private final UserManager userManager;
    
    public TransactionManager() {
        this.db = DatabaseConnection.getInstance().getConnection();
        this.bookManager = new BookManager();
        this.userManager = new UserManager();
    }
    
    public void issueBook(int userId, int bookId) {
        // Check if user and book exist and book is available
        User user = userManager.findUser(userId);
        Book book = bookManager.findBook(bookId);
        if (user == null || book == null) {
            System.out.println("User or Book not found.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is not available.");
            return;
        }

        String sql = "INSERT INTO Transactions (userID, bookID, issueDate, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, bookId);
            pstmt.setObject(3, LocalDate.now()); // Current date
            pstmt.setString(4, "Issued");
            pstmt.executeUpdate();

            // Update book availability
            book.setAvailable(false);
            bookManager.updateBook(book);
            System.out.println("Book" + book.getTitle() + " issued to " + user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnBook(int transactionId) {
        String sql = "UPDATE Transactions SET returnDate = ?, status = ? WHERE transactionId = ? AND status = 'Issued'";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setObject(1, LocalDate.now());
            pstmt.setString(2, "Returned");
            pstmt.setInt(3, transactionId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Fetch the bookId from the transaction
                Transaction transaction = findTransaction(transactionId);
                if (transaction != null) {
                    Book book = bookManager.findBook(transaction.getBookId());
                    if (book != null) {
                        book.setAvailable(true);
                        bookManager.updateBook(book);
                        System.out.println("Book returned successfully.");
                    }
                }
            } else {
                System.out.println("Transaction not found or already returned.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Transaction> viewTransactions(int userId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM Transactions WHERE userId = ?";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                transactions.add(new Transaction(
                    rs.getInt("transactionId"),
                    rs.getInt("bookId"),
                    rs.getInt("userId"),
                    rs.getObject("issueDate", LocalDate.class),
                    rs.getObject("returnDate", LocalDate.class),
                    rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
    private Transaction findTransaction(int transactionId) {
        String sql = "SELECT * FROM Transactions WHERE transactionId = ?";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, transactionId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Transaction(
                    rs.getInt("transactionId"),
                    rs.getInt("bookId"),
                    rs.getInt("userId"),
                    rs.getObject("issueDate", LocalDate.class),
                    rs.getObject("returnDate", LocalDate.class),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
