package com.company.map;

public class AuthUser {
    String email;
    String role;

    public AuthUser(String email, String role) {
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
