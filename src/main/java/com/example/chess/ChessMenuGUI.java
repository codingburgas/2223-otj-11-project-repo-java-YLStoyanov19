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
        JFrame frame = new ChessGameBoard();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

    private void showHistoryAndRules() {
        String historyAndRules = "Chess is a strategic board game that has been played for centuries and is still widely popular today. It is a two-player game that requires critical thinking, foresight, and skill. The objective of the game is to checkmate the opponent's king, which means placing the king in a position where it cannot escape capture.\n" +
                "\n" +
                "Chess has a rich history that dates back to ancient India and Persia, and it has evolved over time to become the game we know today. The modern rules of chess were standardized in the 19th century, and since then, chess has become a highly competitive and organized sport with official tournaments, ratings, and championships.\n" +
                "\n" +
                "The chessboard consists of 64 squares arranged in an 8x8 grid, and each player starts with 16 pieces: one king, one queen, two rooks, two knights, two bishops, and eight pawns. The pieces move in specific ways, and each piece has its own unique abilities and limitations.\n" +
                "\n" +
                "The most powerful piece in chess is the queen, which can move any number of squares in any direction. The rooks move along ranks and files, the bishops move diagonally, and the knights move in an L-shape, making them the only pieces that can \"jump\" over other pieces. The pawns move forward one or two squares on their first move and then one square at a time thereafter, capturing diagonally.\n" +
                "\n" +
                "Chess is a game of strategy and tactics, and players must plan their moves carefully to outwit their opponents. Common strategies include controlling the center of the board, developing pieces to their optimal squares, and coordinating attacks. Tactics involve combinations of moves to gain material advantage or create threats against the opponent's king.\n" +
                "\n" +
                "In addition to the basic rules, there are several special moves in chess. One such move is castling, where the king and one of the rooks move together to improve the king's safety and connect the rooks. Another special move is en passant, where a pawn captures an opponent's pawn that has moved two squares forward from its starting position. Promotion is also a unique rule in chess, where a pawn that reaches the opposite side of the board can be promoted to any other piece, except the king.\n" +
                "\n" +
                "Chess has a rich and diverse community with players of all ages, genders, and skill levels. There are numerous chess clubs, organizations, and online platforms where players can compete, learn, and socialize. Chess is also recognized as a sport by many international organizations, and it has its own system of ratings to rank players' performance.\n" +
                "\n" +
                "One of the most prestigious events in the chess world is the World Chess Championship, where the top players from around the world compete for the title of the world champion. The championship match is typically held every two years, and it is governed by FIDE (Federation Internationale des Échecs), the international chess federation.\n" +
                "\n" +
                "Chess has also seen significant advancements in technology in recent years. Computer chess programs, also known as chess engines, have become incredibly powerful and are capable of defeating even the strongest human players. These engines use complex algorithms and artificial intelligence techniques to analyze millions of moves per second and make optimal decisions. Computer-assisted chess, where human players use chess engines to analyze positions and suggest moves, has become a popular training tool for players of all levels.";

        JTextArea historyAndRulesTextArea = new JTextArea(historyAndRules);
        historyAndRulesTextArea.setEditable(false);
        historyAndRulesTextArea.setLineWrap(true);
        historyAndRulesTextArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(historyAndRulesTextArea);
        scrollPane.setPreferredSize(new Dimension(1280, 720));
        JOptionPane   .showMessageDialog(this, scrollPane, "History and Rules of Chess", JOptionPane.INFORMATION_MESSAGE);

    }

    private void startPlayerVsPlayerGame() {
        // TODO: Implement logic to start a player versus player game
        JFrame frame = new ChessGameBoard();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessMenuGUI chessMenu = new ChessMenuGUI();
            chessMenu.setVisible(true);
        });
    }
}
