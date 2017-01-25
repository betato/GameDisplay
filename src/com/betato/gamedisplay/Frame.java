package com.betato.gamedisplay;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static final long serialVersionUID = 1L;

	public Frame(int width, int height, String title) {
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(title);
	}
	
	public void createFrame(GameWindow gameWindow) {
		add(gameWindow);
		pack();
		setResizable(false);
		setVisible(true);
	}
}
