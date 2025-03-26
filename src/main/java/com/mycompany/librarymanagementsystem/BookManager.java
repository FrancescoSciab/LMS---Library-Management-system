/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author francescosciabbarrasi
 */
public class BookManager implements BookOperations {
    private final Connection db; //check this
    
    public BookManager() {
        this.db = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void updateBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteBook(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Book findBook(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void addBook (Book book) {
        String sql = "INSERT INTO Books (ID, title, author, genre, availability) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = db.prepareStatement(sql)) {
            pstmt.setInt(1, book.getId());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getGenre());
            pstmt.setBoolean(5, book.isAvailable());
            pstmt.executeUpdate();
            System.out.println("Book added: " + book.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
