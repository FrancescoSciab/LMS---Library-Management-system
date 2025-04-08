/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementsystem.factory;
import com.mycompany.librarymanagementsystem.model.User;
import com.mycompany.librarymanagementsystem.model.AdminUser;
import com.mycompany.librarymanagementsystem.model.MemberUser;

/**
 *
 * @author francescosciabbarrasi
 */
public class UserFactory {
    public static User createUser(int id, String name, String role, String email, String password) {
        return switch (role.toLowerCase()) {
            case "admin" -> new AdminUser(id, name, email, password);
            case "member" -> new MemberUser(id, name, email, password);
            default -> throw new IllegalArgumentException("Invalid role: " + role);
        };     
    } 
}
