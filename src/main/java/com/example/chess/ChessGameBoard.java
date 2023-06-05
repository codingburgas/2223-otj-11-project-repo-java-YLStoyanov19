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
        Dimension boardSize = new Dimension(680, 680);

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

        // The chess pieces added as photos
        ImageIcon chessWhitePawn = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\white_p.png");
        ImageIcon chessBlackPawn = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\black_p.png");
        ImageIcon chessWhiteRook = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\white_r.png");
        ImageIcon chessBlackRook = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\black_r.png");
        ImageIcon chessWhiteKnight = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\white_kn.png");
        ImageIcon chessBlackKnight = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\black_kn.png");
        ImageIcon chessWhiteBishop = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\white_b.png");
        ImageIcon chessBlackBishop = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\black_b.png");
        ImageIcon chessWhiteQueen = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\white_q.png");
        ImageIcon chessBlackQueen = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\black_q.png");
        ImageIcon chessWhiteKing = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\white_k.png");
        ImageIcon chessBlackKing = new ImageIcon("C:\\Users\\YLStoyanov19\\IdeaProjects\\2223-otj-11-project-repo-java-YLStoyanov19\\Images\\Chess_Pieces\\black_k.png");


        //white chess pawns
        addPieceToSquare(chessWhitePawn, 48);
        addPieceToSquare(chessWhitePawn, 49);
        addPieceToSquare(chessWhitePawn, 50);
        addPieceToSquare(chessWhitePawn, 51);
        addPieceToSquare(chessWhitePawn, 52);
        addPieceToSquare(chessWhitePawn, 53);
        addPieceToSquare(chessWhitePawn, 54);
        addPieceToSquare(chessWhitePawn, 55);

        //Black chess pawn
        addPieceToSquare(chessBlackPawn, 8);
        addPieceToSquare(chessBlackPawn, 9);
        addPieceToSquare(chessBlackPawn, 10);
        addPieceToSquare(chessBlackPawn, 11);
        addPieceToSquare(chessBlackPawn, 12);
        addPieceToSquare(chessBlackPawn, 13);
        addPieceToSquare(chessBlackPawn, 14);
        addPieceToSquare(chessBlackPawn, 15);

        //White chess Rooks
        addPieceToSquare(chessWhiteRook, 56);
        addPieceToSquare(chessWhiteRook, 63);

        //Black chess Rooks
        addPieceToSquare(chessBlackRook, 0);
        addPieceToSquare(chessBlackRook, 7);

        //White chess Knights
        addPieceToSquare(chessWhiteKnight, 57);
        addPieceToSquare(chessWhiteKnight, 62);

        //Black chess Knights
        addPieceToSquare(chessBlackKnight, 1);
        addPieceToSquare(chessBlackKnight, 6);

        //White chess Bishops
        addPieceToSquare(chessWhiteBishop, 58);
        addPieceToSquare(chessWhiteBishop, 61);

        //Black chess Bishops
        addPieceToSquare(chessBlackBishop, 2);
        addPieceToSquare(chessBlackBishop, 5);

        //White chess Queen
        addPieceToSquare(chessWhiteQueen, 59);

        //Black chess Queen
        addPieceToSquare(chessBlackQueen, 3);

        //White chess King
        addPieceToSquare(chessWhiteKing, 60);

        //Black chess King
        addPieceToSquare(chessBlackKing, 4);


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