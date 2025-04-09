/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.manager;

import com.mycompany.librarymanagementsystem.model.Book;
import com.mycompany.librarymanagementsystem.BookOperations;
import com.mycompany.librarymanagementsystem.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author francescosciabbarrasi
 */
public class BookManager implements BookOperations {
    private final Connection db; 
    
    public BookManager() {
        this.db = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void updateBook(Book book) {
        String sql = "UPDATE Books SET title = ?, author = ?, genre = ?, available = ? WHERE id = ?";
                try (PreparedStatement pstmt = db.prepareStatement(sql)) {
                    pstmt.setString(1, book.getTitle());
                    pstmt.setString(2, book.getAuthor());
                    pstmt.setString(3, book.getGenre());
                    pstmt.setBoolean(4, book.isAvailable());
                    pstmt.setInt(5, book.getId());
                    pstmt.executeUpdate();
                    System.out.println("Book updated: " + book.getTitle());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
}

    @Override
    public void deleteBook(int bookId) {
        String sql = "DELETE FROM Books WHERE id = ?";
                try (PreparedStatement pstmt = db.prepareStatement(sql)) {
                    pstmt.setInt(1, bookId);
                    pstmt.executeUpdate();
                    System.out.println("Book deleted with ID: " + bookId);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }

    @Override
    public Book findBook(int bookId) {
        String sql = "SELECT * FROM Books WHERE id = ?";
                try (PreparedStatement pstmt = db.prepareStatement(sql)) {
                    pstmt.setInt(1, bookId);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        return new Book(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("genre"),
                            rs.getBoolean("availability")
                        );
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
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
    
    

