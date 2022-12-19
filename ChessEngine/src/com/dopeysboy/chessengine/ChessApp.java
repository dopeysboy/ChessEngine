package com.dopeysboy.chessengine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.dopeysboy.chessengine.pieces.ChessPiece;

public class ChessApp extends JFrame{
	public static final int WINDOW_HEIGHT = 512;
	public static final int WINDOW_WIDTH = 512;
	public static final int BOARD_HEIGHT = 8;
	public static final int BOARD_WIDTH = 8;
	public static final int SQUARE_WIDTH = WINDOW_WIDTH / BOARD_WIDTH;
	public static final int SQUARE_HEIGHT = WINDOW_HEIGHT / BOARD_HEIGHT;
	
	private Font font = new Font("Unicode", Font.PLAIN, 30);
	
	public static final Color BLACK_SQUARE = new Color(80, 99, 48);
	public static final Color WHITE_SQUARE  = new Color(230, 228, 165);

	private JButton[][] squares = new JButton[8][8];
	
	public static void main(String[] args) {
		createBoard();
	}
	
	public ChessApp(String name) {
		super(name);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, WINDOW_WIDTH, WINDOW_WIDTH);
	}
	
	private static void createBoard() {
		ChessApp frame = new ChessApp("Chess");
		frame.addComponentsToFrame(frame.getContentPane());
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private void addComponentsToFrame(final Container pane) {
		final JPanel components = new JPanel();
		components.setLayout(new GridLayout(BOARD_HEIGHT, BOARD_WIDTH));
		
		for(int x = 0; x < BOARD_WIDTH; x++) {
			for(int y = 0; y < BOARD_HEIGHT; y++) {
				JButton square = new JButton();
				square.setFont(font);
				
				square.setPreferredSize(new Dimension(SQUARE_WIDTH, SQUARE_HEIGHT));
				if( (x + y) % 2 == 0) {
					square.setBackground(BLACK_SQUARE);
					square.setText(ChessPiece.image);
				} else {
					square.setBackground(WHITE_SQUARE);
				}
				
				squares[x][y] = square; 
				components.add(square);
			}
		}
		
		pane.add(components, BorderLayout.NORTH);
	}
}
