package com.wasayt.database;

import com.wasayt.model.MediaFile;
import com.wasayt.model.Playlist;
import com.wasayt.model.User;

/**
 * Manages database connectivity and CRUD operations.
 * Currently simulates database actions for demonstration.
 * 
 * @author Ruba Al-Harazin
 */
public class DatabaseManager {
    private final String dbPath;
    private boolean isConnected;

    public DatabaseManager(String dbPath) {
        this.dbPath = dbPath;
        this.isConnected = false;
    }

    public void connect() {
        // TODO: Implement JDBC connection logic here
        // Example: Class.forName("org.sqlite.JDBC");
        isConnected = true;
        System.out.println("🔗 Connected to database: " + dbPath);
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("🔌 Disconnected from database.");
    }

    public boolean saveUser(User user) {
        if (isConnected) {
            System.out.println("💾 Saving user: " + user.getUsername());
            return true;
        }
        return false;
    }

    public void saveMediaFile(MediaFile file) {
        if (isConnected) {
            System.out.println("💾 Saving media: " + file.getFileName());
        }
    }

    public void savePlaylist(Playlist playlist) {
        if (isConnected) {
            System.out.println("💾 Saving playlist: " + playlist.getPlaylistName());
        }
    }

    public boolean isConnected() { return isConnected; }
}