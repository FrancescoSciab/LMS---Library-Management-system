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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewTransactions method, of class TransactionManager.
     */
    @Test
    public void testViewTransactions() {
        System.out.println("viewTransactions");
        int userId = 0;
        TransactionManager instance = new TransactionManager();
        List<Transaction> expResult = null;
        List<Transaction> result = instance.viewTransactions(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
