package com.example.chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessGameBoard extends JFrame implements MouseListener, KeyListener {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
    int startX;
    int startY;
    int endX;
    int endY;
    boolean drawLines;
    Color outlineColor;

    public ChessGameBoard() {
        Dimension boardSize = new Dimension(600, 600);

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addKeyListener(this);
        layeredPane.setFocusable(true);

        // Add a chess board to the Layered Pane

        chessBoard = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(outlineColor);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
        };
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout(new GridLayout(8, 8));
        chessBoard.setPreferredSize(boardSize);
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);

        for (int i = 0; i < 64; i++) {
            JPanel square = new JPanel(new BorderLayout());
            chessBoard.add(square);

            int row = (i / 8) % 2;
            if (row == 0)
                square.setBackground(i % 2 == 0 ? Color.white : Color.darkGray);
            else
                square.setBackground(i % 2 == 0 ? Color.darkGray : Color.white);
        }

        // Add a few pieces to the board

        ImageIcon chessIcon = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\black.png");
        ImageIcon chess1Icon = new ImageIcon("/home/vinod/resamples/chess1.jpg");
        ImageIcon kingIcon = new ImageIcon("/home/vinod/resamples/king.jpg");
        ImageIcon camelIcon = new ImageIcon("/home/vinod/resamples/camel.jpg");

        addPieceToSquare(chessIcon, 0);
        addPieceToSquare(chess1Icon, 15);
        addPieceToSquare(kingIcon, 16);
        addPieceToSquare(camelIcon, 20);

        drawLines = true;
        outlineColor = Color.GREEN;
    }

    private void addPieceToSquare(ImageIcon icon, int squareIndex) {
        JLabel piece = new JLabel(icon);
        JPanel panel = (JPanel) chessBoard.getComponent(squareIndex);
        panel.add(piece);
    }

    // Rest of the code...

    public static void main(String[] args) {
        JFrame frame = new ChessGameBoard();
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            startX = e.getX();
            startY = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3 && drawLines) {
            endX = e.getX();
            endY = e.getY();
            Graphics g = chessBoard.getGraphics();
            g.setColor(Color.GREEN);
            g.drawLine(startX, startY, endX, endY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Not used
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Optionally, clear the starting coordinates when the mouse exits the board
        startX = 0;
        startY = 0;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            chessBoard.getGraphics().clearRect(0, 0, chessBoard.getWidth(), chessBoard.getHeight());
            drawLines = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}
