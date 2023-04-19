package com.example.chess;

import javax.swing.*;

public class ChessMenuGUI extends JFrame {
    private JMenuItem historyAndRulesMenuItem;
    private JMenuItem playWithAIMenuItem;
    private JMenuItem playerVsPlayerMenuItem;

    public ChessMenuGUI() {
        setTitle("Chess Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create "File" menu
        JMenu fileMenu = new JMenu("File");

        // Create "History and Rules of Chess" menu item
        historyAndRulesMenuItem = new JMenuItem("History and Rules of Chess");
        fileMenu.add(historyAndRulesMenuItem);

        // Create "Play" menu
        JMenu playMenu = new JMenu("Play");

        // Create "Play with AI" menu item
        playWithAIMenuItem = new JMenuItem("Play with AI");
        playMenu.add(playWithAIMenuItem);

        // Create "Player versus Player" menu item
        playerVsPlayerMenuItem = new JMenuItem("Player versus Player");
        playMenu.add(playerVsPlayerMenuItem);

        // Add "File" and "Play" menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(playMenu);

        // Set menu bar for the frame
        setJMenuBar(menuBar);

        // Add action listeners for menu items
        historyAndRulesMenuItem.addActionListener(e -> showHistoryAndRules());
        playWithAIMenuItem.addActionListener(e -> startGameWithAI());
        playerVsPlayerMenuItem.addActionListener(e -> startPlayerVsPlayerGame());
    }

    private void showHistoryAndRules() {
        // TODO: Implement logic to display history and rules of chess
        JOptionPane.showMessageDialog(this, "Displaying History and Rules of Chess");
    }

    private void startGameWithAI() {
        // TODO: Implement logic to start a game with AI
        JOptionPane.showMessageDialog(this, "Starting Game with AI");
    }

    private void startPlayerVsPlayerGame() {
        // TODO: Implement logic to start a player versus player game
        JOptionPane.showMessageDialog(this, "Starting Player versus Player Game");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessMenuGUI chessMenu = new ChessMenuGUI();
            chessMenu.setVisible(true);
        });
    }
}