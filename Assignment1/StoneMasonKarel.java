/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import java.io.*;
import stanford.karel.*;


public class StoneMasonKarel extends SuperKarel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
		int counter = 1;
		while ( true ) {
			while (frontIsClear()) {
				putBeeper();
				move();
			}
			putBeeper();
			if (counter % 2 == 1) {
				turnRight();
			}
			else {
				turnLeft();
			}
			if (frontIsClear()) {
				move();
				move();
				move();
				move();
			}
			else {
				return;
			}
			if (counter % 2 == 1) {
				turnRight();
				counter ++;
			}
			else {
				turnLeft();
				counter ++;
			}
			
		}
	}
}
