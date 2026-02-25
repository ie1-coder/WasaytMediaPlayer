package com.wasayt.controller;

/**
 * Core engine responsible for media playback logic.
 * Handles play, pause, stop, volume, and speed controls.
 * 
 * @author Ruba Al-Harazin
 */
public class MediaPlayerEngine {
    
    public enum State { PLAYING, PAUSED, STOPPED }
    
    private State currentState;
    private double volume;
    private double playbackSpeed;

    public MediaPlayerEngine() {
        this.currentState = State.STOPPED;
        this.volume = 50.0; // Default volume 50%
        this.playbackSpeed = 1.0; // Normal speed
    }

    public void play() {
        currentState = State.PLAYING;
        System.out.println("▶ Media is playing...");
    }

    public void pause() {
        if (currentState == State.PLAYING) {
            currentState = State.PAUSED;
            System.out.println("⏸ Media paused.");
        }
    }

    public void stop() {
        currentState = State.STOPPED;
        System.out.println("⏹ Media stopped.");
    }

    public void setVolume(double level) {
        if (level >= 0 && level <= 100) {
            this.volume = level;
            System.out.println("🔊 Volume set to: " + (int)level + "%");
        }
    }

    public void mute() {
        System.out.println("🔇 Audio muted.");
    }

    public void setPlaybackSpeed(double speed) {
        if (speed > 0) {
            this.playbackSpeed = speed;
            System.out.println("⚡ Speed set to: " + speed + "x");
        }
    }

    public void next() { System.out.println("⏭ Next track"); }
    public void previous() { System.out.println("⏮ Previous track"); }

    // --- Getters ---
    public State getCurrentState() { return currentState; }
    public double getVolume() { return volume; }
}