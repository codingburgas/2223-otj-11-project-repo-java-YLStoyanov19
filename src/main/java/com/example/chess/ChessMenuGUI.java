package com.example.chess;

import javax.swing.*;
import java.awt.*;

public class ChessMenuGUI extends JFrame {

    public ChessMenuGUI() {
        setTitle("Chess");
        setSize(2020, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create "File" menu
        JMenu fileMenu = new JMenu("Learn Chess");

        // Create "History and Rules of Chess" menu item
        JMenuItem historyAndRulesMenuItem = new JMenuItem("History and Rules of Chess");
        fileMenu.add(historyAndRulesMenuItem);

        // Create "Play" menu
        JMenu playMenu = new JMenu("Play");

        // Create "Play with AI" menu item
        JMenuItem playWithAIMenuItem = new JMenuItem("Player versus AI");
        playMenu.add(playWithAIMenuItem);

        // Create "Player versus Player" menu item
        JMenuItem playerVsPlayerMenuItem = new JMenuItem("Player versus Player");
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

    private void startGameWithAI() {
        // TODO: Implement logic to start a game with AI
        JOptionPane.showMessageDialog(this, "Starting Game with AI");
    }

    private void showHistoryAndRules() {
        String historyAndRules = "History of Chess:\n"
                + "Chess is believed to have originated in Northern India during the Gupta Empire in the 6th century AD. "
                + "It then spread to Persia and eventually to the Islamic empire and other parts of the world.\n\n"
                + "Rules of Chess:\n"
                + "1. Chess is a two-player strategy game played on an 8x8 board.\n"
                + "2. Each player starts with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns.\n"
                + "3. The goal is to checkmate the opponent's king, which means putting the king in a position where it is under attack and cannot escape capture.\n"
                + "4. Each piece has its own unique moves: the king moves one square in any direction, the queen can move any number of squares in any direction, the rook moves horizontally or vertically, the bishop moves diagonally, the knight moves in an L-shape, and the pawn moves forward one or two squares initially and then one square forward or diagonally to capture.\n"
                + "5. The game ends when a player checkmates the opponent's king, stalemates the opponent's king, or the game is a draw due to a threefold repetition, insufficient material, or a draw offer.\n\n"
                + "Have fun playing Chess!";

        JTextArea historyAndRulesTextArea = new JTextArea(historyAndRules);
        historyAndRulesTextArea.setEditable(false);
        historyAndRulesTextArea.setLineWrap(true);
        historyAndRulesTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(historyAndRulesTextArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        JOptionPane   .showMessageDialog(this, scrollPane, "History and Rules of Chess", JOptionPane.INFORMATION_MESSAGE);
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
