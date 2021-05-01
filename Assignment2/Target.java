/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		GOval outerCircle = new GOval (100, 100, 100, 100);
		outerCircle.setFillColor(Color.RED);
		outerCircle.setFilled(true);
		GOval middleCircle = new GOval (115, 115, 70, 70);
		middleCircle.setFillColor(Color.WHITE);
		middleCircle.setFilled(true);
		GOval centerCircle = new GOval (135, 135, 30, 30);
		centerCircle.setFillColor(Color.RED);
		centerCircle.setFilled(true);
		add(outerCircle);
		add(middleCircle);
		add(centerCircle);
	}
}
