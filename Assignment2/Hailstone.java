/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;
public class Hailstone extends ConsoleProgram {
	public static final int SENTINEL = 0;
	public void run() {
		int n;
		do {
			n = readInt("Enter a number: ");
			int counter = 0;
			if (n == SENTINEL) {
				break;
			}
			do {
				if (n % 2 == 0 && n != 1) {
					System.out.print(n + " is even, so I take half: ");
					n = n / 2;
					System.out.print(n);
					counter ++;
					System.out.println();
				}
				else if (n % 2 != 0 && n != 1) {
					System.out.print(n + " is odd, so I make 3n + 1: ");
					n = 3 * n + 1;
					System.out.print(n);
					counter ++;
					System.out.println();
				}
			} while (n != 1);
			System.out.println("The process took " + counter + " to reach 1");
			System.out.println("_____________________________________________");
		} while (n != SENTINEL);
	}
}

