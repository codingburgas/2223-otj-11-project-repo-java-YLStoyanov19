package com.example.chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ChessGameBoard extends JFrame implements MouseListener, MouseMotionListener {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;

    public ChessGameBoard() {
        Dimension boardSize = new Dimension(600, 600);

        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);

        // Add a chess board to the Layered Pane

        chessBoard = new JPanel();
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

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
