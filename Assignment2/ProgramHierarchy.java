/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private static final int width =  130;
	private static final int height = 70;
	private static final int ycord = 200;
	private static final int xcord = 500;
	public void run() {
		add (new GRect(xcord, ycord, width, height));
		add (new GRect(xcord * 0.5, ycord + 100, width, height));
		add (new GRect(xcord, ycord + 100, width, height));
		add (new GRect(xcord * 1.5, ycord + 100, width, height));
		add (new GLine(xcord * 0.5 + width * 0.5, ycord + 100 , xcord + width * 0.5, ycord + height));
		add (new GLine(xcord + width * 0.5, ycord + 100, xcord + width * 0.5, ycord + height));
		add (new GLine(xcord * 1.5 + width * 0.5, ycord + 100, xcord + width * 0.5, ycord + height));
		GLabel program = new GLabel("Program", 0, 0);
		GLabel graphics = new GLabel("GraphicsProgram", 0, 0);
		GLabel console = new GLabel("ConsoleProgram", 300, 250);
		GLabel dialog = new GLabel("DialogProgram", 450, 250);
		program.setLocation(xcord + 0.5 * width - 0.5 * program.getWidth(), ycord + 0.5 * height + 0.5 * program.getAscent());
		graphics.setLocation(xcord * 0.5 + 0.5* width - 0.5* graphics.getWidth(), ycord + 100 + 0.5 * height + 0.5 * graphics.getAscent());
		console.setLocation(xcord + 0.5* width - 0.5* console.getWidth(), ycord + 100 + 0.5 * height + 0.5 * console.getAscent());
		dialog.setLocation(xcord * 1.5 + 0.5* width - 0.5* dialog.getWidth(), ycord + 100 + 0.5 * height + 0.5 * dialog.getAscent());
		add(program);
		add(graphics);
		add(console);
		add(dialog);
	}
}
