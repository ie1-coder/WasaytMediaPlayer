package com.wasayt;

import com.wasayt.controller.MediaLibrary;
import com.wasayt.controller.MediaPlayerEngine;
import com.wasayt.database.DatabaseManager;
import com.wasayt.view.MainView;

/**
 * Application Entry Point.
 * Initializes system components and launches the GUI.
 * 
 * @author Ruba Al-Harazin
 */
public class WasaytMediaPlayer {
    
    public static void main(String[] args) {
        System.out.println("=== 🎬 Wasayt Media Player Started ===");
        
        // 1. Initialize Database Layer
        DatabaseManager db = new DatabaseManager("wasayt_data.db");
        db.connect();
        
        // 2. Initialize Business Logic (Controllers)
        MediaLibrary library = new MediaLibrary();
        MediaPlayerEngine player = new MediaPlayerEngine();
        
        // 3. Launch User Interface (View)
        // Note: Swing apps should be started on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainView view = new MainView();
            
            // Simple interaction demo: Linking View to Controller
            view.setPlayAction(e -> {
                player.play();
                view.updateStatus("Playing selected media...");
            });
            
            // Demo: Importing dummy data
            library.importFile("/user/media/song.mp3");
            library.importFile("/user/media/video.mp4");
            
            // Update View with library content
            library.getAllMedia().forEach((_item) -> {
                view.addFileToList(file.getFileName());
            });
            
            view.updateStatus("System Ready. Files loaded: " + library.getTotalFiles());
        });
    }
}