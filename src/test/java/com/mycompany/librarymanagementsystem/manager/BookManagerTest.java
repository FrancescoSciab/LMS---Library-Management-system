/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.librarymanagementsystem.manager;

import com.mycompany.librarymanagementsystem.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author francescosciabbarrasi
 */
public class BookManagerTest {
    
    public BookManagerTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }


    /**
     * Test of deleteBook method, of class BookManager.
     */
    @org.junit.jupiter.api.Test
    public void testDeleteBook() {
        System.out.println("deleteBook");
        int bookId = 0;
        BookManager instance = new BookManager();
        instance.deleteBook(bookId);
       
    }

    /**
     * Test of addBook method, of class BookManager.
     */
    @org.junit.jupiter.api.Test
    public void testAddBook() {
        System.out.println("addBook");
        Book book = new Book(0, "Atomic habits", "john", "creative thinking", true);
        BookManager instance = new BookManager();
        instance.addBook(book);
        
    }
    
}
