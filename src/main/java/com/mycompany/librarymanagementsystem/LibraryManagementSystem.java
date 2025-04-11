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
import com.mycompany.librarymanagementsystem.manager.TransactionManager;
import com.mycompany.librarymanagementsystem.model.Transaction;
import com.mycompany.librarymanagementsystem.service.NotificationService;
import java.util.Scanner;
import java.util.List;
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
        TransactionManager transactionManager = new TransactionManager();
        NotificationService notificationService = new NotificationService();
        
        while (true) {
            System.out.println("1 = Admin Panel\n2 = Member Panel\n3 = Notifications\n-1 = Exit");
            int choice = scanner.nextInt();
            if (choice == -1) break;
            
            switch (choice) {
                case 1: //Adming panel
                    System.out.println("Admin: a = Manage Books, b = Manage Users");
                    char adminChoice = scanner.next().charAt(0);
                    scanner.nextLine();
                    if (adminChoice == 'a') {
                        System.out.println("Enter book title, author, genre:");
                        
                        String title = scanner.nextLine();
                        String author = scanner.nextLine();
                        String genre = scanner.nextLine();
                        Book book = new Book(0, title, author, genre, true);
                        bookManager.addBook(book);
                    } else if (adminChoice == 'b') {
                        System.out.println("1 = Add User, 2 = Update User, 3 = Delete User, 4 = Find User");
                        int userChoice = scanner.nextInt();
                        scanner.nextLine(); // Clear buffer
                        switch (userChoice) {
                            case 1: // Add User
                                System.out.println("Enter name, role (Admin/Member), email, password:");
                                String name = scanner.nextLine();
                                String role = scanner.nextLine();
                                String email = scanner.nextLine();
                                String password = scanner.nextLine();
                                User user = UserFactory.createUser(0, name, role, email, password);
                                userManager.addUser(user);
                                break;
                            case 2: // Update User
                                System.out.println("Enter user ID, new name, email, password:");
                                int id = scanner.nextInt();
                                scanner.nextLine();
                                String newName = scanner.nextLine();
                                String newEmail = scanner.nextLine();
                                String newPassword = scanner.nextLine();
                                User existingUser = userManager.findUser(id);
                                if (existingUser != null) {
                                    User updatedUser = UserFactory.createUser(id, newName, existingUser.getRole(), newEmail, newPassword);
                                    userManager.updateUser(updatedUser);
                                } else {
                                    System.out.println("User not found.");
                                }
                                break;
                            case 3: // Delete User
                                System.out.println("Enter user ID:");
                                int deleteId = scanner.nextInt();
                                userManager.deleteUser(deleteId);
                                break;
                            case 4: // Find User
                                System.out.println("Enter user ID:");
                                int findId = scanner.nextInt();
                                User foundUser = userManager.findUser(findId);
                                if (foundUser != null) {
                                    System.out.println("Found: " + foundUser.getName() + ", " + foundUser.getRole());
                                    if (foundUser instanceof com.mycompany.librarymanagementsystem.model.AdminUser) {
                                        ((com.mycompany.librarymanagementsystem.model.AdminUser) foundUser).manageSystem();
                                    } else if (foundUser instanceof com.mycompany.librarymanagementsystem.model.MemberUser) {
                                        ((com.mycompany.librarymanagementsystem.model.MemberUser) foundUser).borrowBook();
                                    }
                                } else {
                                    System.out.println("User not found.");
                                }
                                break;
                            default:
                                System.out.println("Invalid option!");
                        }
                    }
                    break;
//                    System.out.println("Enter book title, author, genre:");
//                    scanner.nextLine();
//                    String title = scanner.nextLine();
//                    String author = scanner.nextLine();
//                    String genre = scanner.nextLine();
//                    Book bookTest = new Book(0123456710, title, author, genre, true);
//                    bookManager.addBook(bookTest);
//                    break;
                case 2: // Member Panel
                    System.out.println("Member: a = Borrow Book, b = Return Book, c = View Issued Books");
                    char memberChoice = scanner.next().charAt(0);
                    scanner.nextLine(); // Clear buffer
                    if (memberChoice == 'a') {
                        System.out.println("Enter your user ID and book ID:");
                        int userId = scanner.nextInt();
                        int bookId = scanner.nextInt();
                        transactionManager.issueBook(userId, bookId);
                    } else if (memberChoice == 'b') {
                        System.out.println("Enter transaction ID:");
                        int transactionId = scanner.nextInt();
                        transactionManager.returnBook(transactionId);
                    } else if (memberChoice == 'c') {
                        System.out.println("Enter your user ID:");
                        int viewUserId = scanner.nextInt();
                        List<Transaction> transactions = transactionManager.viewTransactions(viewUserId);
                        if (transactions.isEmpty()) {
                            System.out.println("No transactions found.");
                        } else {
                            for (Transaction t : transactions) {
                                System.out.println("Transaction ID: " + t.getTransactionId() +
                                    ", Book ID: " + t.getBookId() +
                                    ", Issue Date: " + t.getIssueDate() +
                                    ", Return Date: " + t.getReturnDate() +
                                    ", Status: " + t.getStatus());
                            }
                        }
                    }
                    break;
                case 3:// Notifications
                    System.out.println("Checking due books...");
                    notificationService.checkDueBooks();
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}
