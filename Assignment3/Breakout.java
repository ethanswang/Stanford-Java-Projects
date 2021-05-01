/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
	private static final Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};
	
	private int XPOS = 0;
	
	private int YPOS = APPLICATION_HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT;
	
	private GRect paddle = new GRect(100, APPLICATION_HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
	
	private GOval ball = new GOval(300, 300, BALL_RADIUS * 2, BALL_RADIUS * 2);
	
	private int ballX = 100;
	private int ballY = 100;
	private int ballRightX = ballX + 20;
	private int ballBottomY = ballY + 20;
	private int ballLeftX = ballX;
	private int ballTopY = ballY;
/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		int xPos = 4;
		int yPos = BRICK_Y_OFFSET;
		int cIndex = 0;
		int lives = 3;
		int nBricks = 100;
		for (int i = 0; i < NBRICK_ROWS; i ++) {
			if (i % 2 == 0 && i != 0) {
				cIndex ++;
				if(cIndex > 4) {
					cIndex = 0;
				}
			}
			for (int j = 0; j < NBRICKS_PER_ROW; j ++) {
				GRect rectangle = new GRect(xPos, yPos, BRICK_WIDTH, BRICK_HEIGHT);
				rectangle.setFilled(true);
				rectangle.setFillColor(colors[cIndex]);
				rectangle.setColor(colors[cIndex]);
				add(rectangle);
				xPos += BRICK_WIDTH + BRICK_SEP;
			}
			xPos = xPos - NBRICKS_PER_ROW * BRICK_WIDTH - NBRICKS_PER_ROW * BRICK_SEP;
			yPos += BRICK_HEIGHT + BRICK_SEP;
		}
		paddle.setFilled(true);
		paddle.setFillColor(Color.BLACK);
		add(paddle);
		addMouseListeners();
		vy = 3.0;
		ball.setFilled(true);
		ball.setFillColor(Color.BLACK);
		add(ball);
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) {
			vx = -vx;
		}
		while (lives != 0 && nBricks != 0) {
			// bottom
			GObject collider = getCollidingObject();
			if (ballBottomY >= HEIGHT) {
				lives -= 1;
				System.out.println("Lives left: " + lives);
				ballX = 30;
				ballY = 150;
				ballRightX = ballX + 20;
				ballBottomY = ballY + 20;
				ballLeftX = ballX;
				ballTopY = ballY;
			}
			// top
			if (ballTopY <= 0) {
				vy = -vy;
			}
			// right side
			if (ballRightX >= WIDTH) {
				vx = -vx;
			}
			//left side
			if (ballLeftX <= 0) {
				vx = -vx;
			}
			if (collider == paddle) {
				vy = -vy;
			}
			if (collider != paddle && collider != null) {
				vy = -vy;
				remove(collider);
				nBricks -= 1;
			}
			ballMove(ballX, ballY);
			pause(10);
		}
		if (lives == 0) {
			System.out.println("You Lose!");
		}
		else {
			System.out.println("You Win!");
		}
		
	}
	public GObject getCollidingObject() {
		if (getElementAt(ballX, ballY) != null) {
			return getElementAt(ballX, ballY);
		}
		else if (getElementAt(ballX + 2 * BALL_RADIUS, ballY + 2 * BALL_RADIUS) != null) {
			return getElementAt(ballX + 2 * BALL_RADIUS, ballY + 2 * BALL_RADIUS);
		}
		else if (getElementAt(ballX, ballY + 2 * BALL_RADIUS) != null) {
			return getElementAt(ballX, ballY + 2 * BALL_RADIUS);
		}
		else if (getElementAt(ballX + 2 * BALL_RADIUS, ballY) != null) {
			return getElementAt(ballX + 2 * BALL_RADIUS, ballY);
		}
		else {
			return null;
		}
	}
	public void ballMove(int x, int y) {
		ball.setLocation(x + vx, y + vy);
		ballX += vx;
		ballY += vy;
		ballLeftX += vx;
		ballTopY += vy;
		ballRightX += vx;
		ballBottomY += vy;
	}
	
	public void mouseMoved(MouseEvent e) {
		XPOS = e.getX();
		if (XPOS < WIDTH - PADDLE_WIDTH && XPOS > 0) {
			paddle.setLocation(XPOS, YPOS);
		}
	}
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
