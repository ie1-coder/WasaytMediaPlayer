package com.wasayt.model;

/**
 * Represents a system user with authentication capabilities.
 * 
 * @author Ruba Al-Harazin
 */
public class User {
    private final String userId;
    private final String username;
    private final String passwordHash; // In production, store hashed passwords only
    private final String role; // "Admin" or "User"

    public User(String userId, String username, String passwordHash, String role) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    /**
     * Simulates user login process.
     * @return true if login is successful
     */
    public boolean login() {
        if (validateCredentials()) {
            System.out.println("User " + username + " logged in successfully.");
            return true;
        }
        return false;
    }

    /**
     * Validates credentials (placeholder logic).
     * @return 
     */
    public boolean validateCredentials() {
        return passwordHash != null && !passwordHash.isEmpty();
    }

    public void logout() {
        System.out.println("User logged out.");
    }

    // --- Getters ---
    public String getUsername() { return username; }
    public String getRole() { return role; }
    public String getUserId() { return userId; }
}