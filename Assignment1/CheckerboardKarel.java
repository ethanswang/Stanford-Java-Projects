/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
		int counter = 1;
		while (leftIsClear()) {
			if (counter % 2 != 0) {
				putBeeper();
			}
			move();
			counter ++;
			if (frontIsBlocked() && facingEast()) {
				turnLeft();
				if (frontIsBlocked()) {
					return;
				}
				move();
				counter ++;
				turnLeft();
			}
			else if (frontIsBlocked() && facingWest()) {
				turnRight();
				if (frontIsBlocked()) {
					return;
				}
				move();
				counter ++;
				turnRight();
			}
		}
		if (counter % 2 != 0) {
			putBeeper();
		}
	}

}
