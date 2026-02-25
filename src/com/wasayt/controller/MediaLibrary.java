package com.wasayt.controller;

import com.wasayt.model.MediaFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the collection of imported media files.
 * Provides search, filter, and sorting capabilities.
 * 
 * @author Ruba Al-Harazin
 */
public class MediaLibrary {
    private final List<MediaFile> allMedia;
    private int totalFiles;

    public MediaLibrary() {
        this.allMedia = new ArrayList<>();
        this.totalFiles = 0;
    }

    /**
     * Imports a file path and creates a MediaFile object.
     * @param path
     * @return 
     */
    public MediaFile importFile(String path) {
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        String fileId = "FILE" + String.format("%03d", totalFiles + 1);
        
        MediaFile.FileType type = determineFileType(path);
        MediaFile newFile = new MediaFile(fileId, fileName, path, type);
        
        allMedia.add(newFile);
        totalFiles++;
        System.out.println("✅ Imported: " + fileName);
        return newFile;
    }

    /**
     * Searches for files containing the query string (case-insensitive).
     * @param query
     * @return 
     */
    public List<MediaFile> searchByName(String query) {
        List<MediaFile> results = new ArrayList<>();
        allMedia.stream().filter((file) -> (file.getFileName().toLowerCase().contains(query.toLowerCase()))).forEachOrdered((file) -> {
            results.add(file);
        });
        return results;
    }

    /**
     * Filters the library by specific media type.
     * @param type
     * @return 
     */
    public List<MediaFile> filterByType(MediaFile.FileType type) {
        List<MediaFile> filtered = new ArrayList<>();
        allMedia.stream().filter((file) -> (file.getFileType() == type)).forEachOrdered((file) -> {
            filtered.add(file);
        });
        return filtered;
    }

    /**
     * Helper method to determine file type based on extension.
     */
    private MediaFile.FileType determineFileType(String path) {
        String lowerPath = path.toLowerCase();
        if (lowerPath.endsWith(".mp3") || lowerPath.endsWith(".wav")) {
            return MediaFile.FileType.AUDIO;
        } else if (lowerPath.endsWith(".mp4") || lowerPath.endsWith(".avi")) {
            return MediaFile.FileType.VIDEO;
        } else if (lowerPath.endsWith(".jpg") || lowerPath.endsWith(".png")) {
            return MediaFile.FileType.IMAGE;
        }
        return MediaFile.FileType.VIDEO; // Default fallback
    }

    public int getTotalFiles() { return totalFiles; }
    public List<MediaFile> getAllMedia() { return allMedia; }
}