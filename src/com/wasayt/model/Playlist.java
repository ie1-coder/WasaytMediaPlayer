package com.wasayt.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a playlist containing a collection of media files.
 * 
 * @author Ruba Al-Harazin
 */
public class Playlist {
    private final String playlistId;
    private final String playlistName;
    private final List<MediaFile> items;

    public Playlist(String playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.items = new ArrayList<>();
    }

    /**
     * Adds a media file to the playlist.
     * @param file
     */
    public void addMedia(MediaFile file) {
        if (file != null && !items.contains(file)) {
            items.add(file);
            System.out.println("Added: " + file.getFileName());
        }
    }

    /**
     * Removes a media file by its ID.
     * @param fileId
     */
    public void removeMedia(String fileId) {
        items.removeIf(file -> file.getFileId().equals(fileId));
    }

    /**
     * Simulates playing the entire playlist.
     */
    public void playAll() {
        System.out.println("Playing playlist: " + playlistName);
        items.forEach((file) -> {
            System.out.println("Now Playing: " + file.getFileName());
        });
    }

    // --- Getters ---
    public String getPlaylistName() { return playlistName; }
    public List<MediaFile> getItems() { return items; }
    public String getPlaylistId() { return playlistId; }
}