/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementsystem;

import com.mycompany.librarymanagementsystem.db.DatabaseConnection;
import com.mycompany.librarymanagementsystem.model.Book;
import com.mycompany.librarymanagementsystem.model.User;
import com.mycompany.librarymanagementsystem.factory.UserFactory;
import com.mycompany.librarymanagementsystem.manager.BookManager;
import com.mycompany.librarymanagementsystem.manager.UserManager;
import java.util.Scanner;

/**
 *
 * @author francescosciabbarrasi
 */
public class LibraryManagementSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        BookManager bookManager = new BookManager();
        UserManager userManager = new UserManager();
        
        while (true) {
            System.out.println("1 = Test book, 2 = Add user, 3 = update user, 4 = Delete user, 5 = Find user");
            int choice = scanner.nextInt();
            if (choice == -1) break;
            
            switch (choice) {
                case 1: 
                    System.out.println("Enter book title, author, genre:");
                    scanner.nextLine();
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    String genre = scanner.nextLine();
                    Book bookTest = new Book(0123456710, title, author, genre, true);
                    bookManager.addBook(bookTest);
                    break;
                case 2: // Add User
                    System.out.println("Enter name, role (Admin/Member), email, password:");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    String role = scanner.nextLine();
                    String email = scanner.nextLine();
                    String password = scanner.nextLine();
                    User user = UserFactory.createUser(0, name, role, email, password);
                    userManager.addUser(user);
                    break;
                case 3: //udpate user
                    System.out.println("Enter user ID, new name, email, password:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    String newName = scanner.nextLine();
                    String newEmail = scanner.nextLine();
                    String newPassword = scanner.nextLine();
                    User updatedUser = new User(id, newName, "Member", newEmail, newPassword); // Role unchanged for simplicity
                    userManager.updateUser(updatedUser);
                    break;
                case 4: // Delete User
                    System.out.println("Enter user ID:");
                    int deleteId = scanner.nextInt();
                    userManager.deleteUser(deleteId);
                    break;
                case 5: // Find User
                    System.out.println("Enter user ID:");
                    int findId = scanner.nextInt();
                    User foundUser = userManager.findUser(findId);
                    if (foundUser != null) {
                        System.out.println("Found: " + foundUser.getName() + ", " + foundUser.getRole());
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}
