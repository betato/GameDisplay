package com.betato.gamedisplay;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame{
	
	public Frame(int width, int height, String title, GameWindow gameWindow) {
		gameWindow.setPreferredSize(new Dimension(width, height));
		gameWindow.setMaximumSize(new Dimension(width, height));
		gameWindow.setMinimumSize(new Dimension(width, height));
		
		gameWindow.frame = new JFrame(title);
		gameWindow.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.frame.add(gameWindow);
		gameWindow.frame.pack();
		gameWindow.frame.setResizable(false);
		gameWindow.frame.setVisible(true);
	}
}
