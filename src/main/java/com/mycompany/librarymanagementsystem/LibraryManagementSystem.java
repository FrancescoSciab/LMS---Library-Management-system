/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementsystem;

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
        
        while (true) {
            System.out.println("1 = Test book");
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
            }
        }
        scanner.close();
    }
}
