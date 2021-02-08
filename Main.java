/**
 * Author: Hunter Stennett
 * Version: 2.1
 */
package com.company;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/**
		 * Leaving this commented out for reference
		 */
		/**
		int fizz;
		int buzz;
		Scanner keyboard = new Scanner(System.in);
		boolean fizzInvalid = false;
		boolean buzzInvalid = false;
		boolean fizzBuzzInvalid = false;


		System.out.println("Enter any number for Fizz between 1-100");
		fizz = keyboard.nextInt();
		while (!fizzInvalid) {
			if (fizz < 0 || fizz > 100) {
				System.out.println("Invalid. Number must be 1-100.");
				fizz = keyboard.nextInt();
			} else {
				fizzInvalid = true;
			}
		}

		System.out.println("Next enter number for Buzz, 1-100");
		buzz = keyboard.nextInt();
		while (!buzzInvalid) {
			if (buzz < 0 || buzz > 100) {
				System.out.println("Invalid. Number must be 1-100");
				buzz = keyboard.nextInt();
			} else {
				buzzInvalid = true;
			}
		}

		while (!fizzBuzzInvalid) {
			for (int i = 1; i <= 100; i++) {
				if (i % fizz == 0 && i % buzz == 0) {
					System.out.println("FizzBuzz");
				} else if (i % fizz == 0) {
					System.out.println("Fizz");
				} else if (i % buzz == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
					if (fizzInvalid == true && buzzInvalid == true) {
						fizzBuzzInvalid = true;
					}
				}
			}
		}*/

		FizzBuzz fb = new FizzBuzz(3, 5);
	}
}
