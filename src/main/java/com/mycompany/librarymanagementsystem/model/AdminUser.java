/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.model;

/**
 *
 * @author francescosciabbarrasi
 */
public class AdminUser extends User {
    public AdminUser(int id, String name, String email, String password) {
        super(id, name, "Admin", email, password);
    }
}
