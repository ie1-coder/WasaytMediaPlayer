package com.wasayt.model;

/**
 * Represents a media file entity in the system.
 * Stores metadata like ID, name, path, and type.
 * 
 * @author Ruba Al-Harazin
 * @version 1.0
 */
public class MediaFile {
    
    private final String fileId;
    private String fileName;
    private String filePath;
    private final FileType fileType;

    /**
     * Enum to define supported media types.
     */
    public enum FileType {
        AUDIO, VIDEO, IMAGE
    }

    /**
     * Constructor to initialize a media file.
     * @param fileId Unique identifier for the file
     * @param fileName Display name of the file
     * @param filePath Absolute path on the disk
     * @param fileType Category of the media
     */
    public MediaFile(String fileId, String fileName, String filePath, FileType fileType) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
    }

    // --- Getters ---
    public String getFileId() { return fileId; }
    public String getFileName() { return fileName; }
    public String getFilePath() { return filePath; }
    public FileType getFileType() { return fileType; }

    // --- Setters ---
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    
    @Override
    public String toString() {
        return fileName; // Ensures file name displays correctly in JList
    }
}