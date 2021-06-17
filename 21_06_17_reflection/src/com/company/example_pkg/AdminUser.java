package com.company.example_pkg;

import com.company.User;

public class AdminUser extends User {

    boolean isAdmin;

    public AdminUser(String email, String name, int phoneNumber) {
        super(email, name, phoneNumber);
        this.isAdmin = true;
    }

//    @Override
//    public String toString() {
//        return "AdminUser{" +
//                "isUser=" + isUser +
//                '}';
//    }

    @Override
    public String toString() {
        return "AdminUser (user){" +
                "isUser=" + isAdmin +
                ", email=" + getEmail() +
                ", name=" + getName() +
                ", phoneNumber=" + getPhoneNumber() +
                "} ";
    }
}
