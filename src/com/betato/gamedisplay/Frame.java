package com.betato.gamedisplay;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/**
 * An extended JFrame for use with a GameWindow. Supports setting content size
 * and cursor hiding.
 */
public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new Frame.
	 * 
	 * @param gameWindow
	 *            The gameWindow to add inside the frame
	 * @param title
	 *            The window title to display
	 * @param width
	 *            The frame width
	 * @param height
	 *            The frame height
	 * @param useContentSize
	 *            If true, the inside of the frame will be set to the specified
	 *            dimensions, if false, the outside will be set
	 * @param resizable
	 *            Whether or not the Frame will be manually resizable
	 * @param hidecursor
	 *            Whether or not to hide the mouse cursor over the Frame
	 * 
	 */
	public Frame(GameWindow gameWindow, String title, int width, int height, boolean useContentSize, boolean resizable,
			boolean hideCursor) {
		add(gameWindow);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle(title);
		if (useContentSize) {
			setContentSize(width, height);
		} else {
			setSize(width, height);
		}

		setResizable(resizable);

		if (hideCursor) {
			setCursorHidden(true);
		}
	}

	/**
	 * Creates a new Frame with fixed size and shown cursor.
	 * 
	 * @param gameWindow
	 *            The gameWindow to add inside the frame
	 * @param title
	 *            The window title to display
	 * @param width
	 *            The frame width
	 * @param height
	 *            The frame height
	 * @param useContentSize
	 *            If true, the inside of the frame will be set to the specified
	 *            dimensions, if false, the outside will be set
	 */
	public Frame(GameWindow gameWindow, String title, int width, int height, boolean useContentSize) {
		this(gameWindow, title, width, height, useContentSize, false, false);
	}

	/**
	 * Sets the mouse cursor to be invisible.
	 * 
	 * @param hideCursor
	 *            Whether or not to use an invisible cursor
	 */
	public void setCursorHidden(boolean hideCursor) {
		if (hideCursor) {
			// Create a new blank cursor
			BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
			Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0),
					"blank cursor");
			// Set the cursor
			getContentPane().setCursor(blankCursor);
		} else {
			// Set default cursor
			getContentPane().setCursor(Cursor.getDefaultCursor());
		}
	}

	/**
	 * Sets the size of the frame based on the specified inner GameWindow size.
	 * 
	 * @param width
	 *            The interior frame width
	 * @param height
	 *            The interior frame height
	 */
	public void setContentSize(int width, int height) {
		// Set content size and pack
		getContentPane().setPreferredSize(new Dimension(width, height));
		pack();
	}
}
