/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem;

/**
 *
 * @author francescosciabbarrasi
 */
public interface UserOperations {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    User findUser(int userId);
}
