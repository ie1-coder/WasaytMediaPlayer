package com.wasayt.view;

import javax.swing.*;
import java.awt.*;

/**
 * Main Graphical User Interface (GUI) for the Wasayt Media Player.
 * Built using Java Swing for cross-platform compatibility.
 * 
 * @author Ruba Al-Harazin
 */
public class MainView extends JFrame {
    
    private JList<String> mediaList;
    private DefaultListModel<String> listModel;
    private JButton btnPlay, btnPause, btnStop;
    private JSlider volumeSlider;
    private JLabel statusLabel;

    public MainView() {
        initUI();
    }

    private void initUI() {
        // Frame Settings
        setTitle("Wasayt Media Player");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen

        // Main Layout
        setLayout(new BorderLayout(10, 10));
        
        // 1. Center: Media List
        listModel = new DefaultListModel<>();
        mediaList = new JList<>(listModel);
        mediaList.setFont(new Font("Arial", Font.PLAIN, 14));
        add(new JScrollPane(mediaList), BorderLayout.CENTER);

        // 2. South: Controls Panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        controlPanel.setBorder(BorderFactory.createTitledBorder("Playback Controls"));
        
        btnPlay = new JButton("▶ Play");
        btnPause = new JButton("⏸ Pause");
        btnStop = new JButton("⏹ Stop");
        
        controlPanel.add(btnPlay);
        controlPanel.add(btnPause);
        controlPanel.add(btnStop);
        
        controlPanel.add(Box.createHorizontalStrut(20)); // Spacer
        
        controlPanel.add(new JLabel("Volume:"));
        volumeSlider = new JSlider(0, 100, 50);
        volumeSlider.setMajorTickSpacing(25);
        volumeSlider.setPaintTicks(true);
        controlPanel.add(volumeSlider);
        
        add(controlPanel, BorderLayout.SOUTH);

        // 3. North: Status Bar
        statusLabel = new JLabel("Ready to play", SwingConstants.CENTER);
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5,0,5,0));
        add(statusLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    // --- Public methods for Controller interaction ---
    
    public void addFileToList(String fileName) {
        listModel.addElement(fileName);
    }

    public void updateStatus(String message) {
        statusLabel.setText(message);
    }

    public int getSelectedVolume() {
        return volumeSlider.getValue();
    }
    
    // Button Listeners can be attached here or in a Controller
    public void setPlayAction(java.awt.event.ActionListener action) {
        btnPlay.addActionListener(action);
    }
}