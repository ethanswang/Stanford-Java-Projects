/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public static final int initialMaxValue = 0;
	public static final int initialMinValue = 0;
	public void run() {
		int max = initialMaxValue;
		int min = initialMinValue;
		int counter = 0;
		int input = 1;
		do {
			input = readInt("Input a number: ");
			if (counter == 0) {
				max = input;
				min = input;
			}
			else {
				if (input > max) {
					max = input;
				}
				if (input < min && input != 0) {
					min = input;
				}
				
			}
			counter ++;
		} while (input != 0);
		if (counter == 1) {
			System.out.println("There were no numbers inputted.");
		}
		else {
			System.out.println("The smallest number is " +  min);
			System.out.println("The largest number is " + max);
		}
	}
}

