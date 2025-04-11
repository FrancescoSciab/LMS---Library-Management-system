/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.librarymanagementsystem.manager;

import com.mycompany.librarymanagementsystem.factory.UserFactory;
import com.mycompany.librarymanagementsystem.model.User;
import com.mycompany.librarymanagementsystem.manager.UserManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author francescosciabbarrasi
 */
public class UserManagerTest {
    
    public UserManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    /**
     * Test of addUser method, of class UserManager.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        UserManager userManager = new UserManager();
        User instance = UserFactory.createUser(0, "Frank", "admin", "frank@gmail.coom", "ciao");
        userManager.addUser(instance);
    }

//    /**
//     * Test of updateUser method, of class UserManager.
//     */
//    @Test
//    public void testUpdateUser() {
//        System.out.println("updateUser");
//        User user = null;
//        UserManager instance = new UserManager();
//        instance.updateUser(user);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteUser method, of class UserManager.
     */
    @Test
    public void testDeleteUser() {
        System.out.println("deleteUser");
        int userId = 4;
        UserManager instance = new UserManager();
        instance.deleteUser(userId);
        
    }

//    /**
//     * Test of findUser method, of class UserManager.
//     */
//    @Test
//    public void testFindUser() {
//        System.out.println("findUser");
//        int userId = 0;
//        UserManager instance = new UserManager();
//        User expResult = null;
//        User result = instance.findUser(userId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
