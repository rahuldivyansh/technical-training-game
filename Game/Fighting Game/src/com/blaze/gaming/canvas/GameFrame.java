package com.blaze.gaming.canvas;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.blaze.gaming.utils.GameConstants;

public class GameFrame extends JFrame implements GameConstants {

	public GameFrame() throws Exception {
		
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(GWIDTH,GHEIGHT);
		setLocationRelativeTo(null);
		Board board = new Board();
		add(board);
		setVisible(true);
		setResizable(true);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GameFrame obj = new GameFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
