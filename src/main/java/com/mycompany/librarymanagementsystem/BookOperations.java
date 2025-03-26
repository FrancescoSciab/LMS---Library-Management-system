/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

/**
 *
 * @author francescosciabbarrasi
 */
public interface BookOperations {
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int bookId);
    Book findBook(int bookId);
}
