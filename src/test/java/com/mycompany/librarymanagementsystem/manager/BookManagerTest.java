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
    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }

    /**
     * Test of updateBook method, of class BookManager.
     */
    @org.junit.jupiter.api.Test
    public void testUpdateBook() {
        System.out.println("updateBook");
        Book book = null;
        BookManager instance = new BookManager();
        instance.updateBook(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBook method, of class BookManager.
     */
    @org.junit.jupiter.api.Test
    public void testFindBook() {
        System.out.println("findBook");
        int bookId = 0;
        BookManager instance = new BookManager();
        Book expResult = null;
        Book result = instance.findBook(bookId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBook method, of class BookManager.
     */
    @org.junit.jupiter.api.Test
    public void testAddBook() {
        System.out.println("addBook");
        Book book = null;
        BookManager instance = new BookManager();
        instance.addBook(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
