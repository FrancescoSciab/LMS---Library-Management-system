/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.librarymanagementsystem.manager;

import com.mycompany.librarymanagementsystem.model.Transaction;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author francescosciabbarrasi
 */
public class TransactionManagerTest {
    
    public TransactionManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of issueBook method, of class TransactionManager.
     */
    @Test
    public void testIssueBook() {
        System.out.println("issueBook");
        int userId = 0;
        int bookId = 0;
        TransactionManager instance = new TransactionManager();
        instance.issueBook(userId, bookId);
        
    }

    /**
     * Test of returnBook method, of class TransactionManager.
     */
    @Test
    public void testReturnBook() {
        System.out.println("returnBook");
        int transactionId = 0;
        TransactionManager instance = new TransactionManager();
        instance.returnBook(transactionId);
        
    }
    
}
