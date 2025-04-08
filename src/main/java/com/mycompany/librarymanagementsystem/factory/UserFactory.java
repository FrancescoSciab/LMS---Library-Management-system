/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.factory;

import com.mycompany.librarymanagementsystem.model.User;

/**
 *
 * @author francescosciabbarrasi
 */
public class UserFactory {
    public static User createUser(int id, String name, String role, String email, String password) {
        return new User(id, name, role, email, password); 
    } 
}
