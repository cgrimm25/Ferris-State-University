/*
 * File: NumberGenerator.java
 * Author: Chris Grimm
 * Date: 9/8/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 1 - Running your First Algorithm
 * Task 3
 * References:
 * Description: Prompts user for a record count and then generates a text file 
 * called numbers.txt that is populated with the inputed specific number of random integers
 * returning the count to the caller.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class NumberGenerator {
	public static int generate() {

		// Setup scanner to read from the console
		Scanner consoleInput = new Scanner(System.in);
		System.out.print("Enter the number of records to generate (limit 100,000): ");

		// Capture the user's input
		int numRec = consoleInput.nextInt();

		// Create or overwrites the numbers.txt file using the inputed size
		try (PrintWriter writer = new PrintWriter(new FileWriter("numbers.txt"))) {
			Random rand = new Random();

			// Generate random number of records based on user input
			for (int i = 0; i < numRec; i++) {

				// Generate a random integer between 0 and 99,999
				writer.println(rand.nextInt(100000));
			}

			return numRec;
			
		} catch (IOException e) {
			System.out.println("An error occurred while writing the file: " + e.getMessage());
			return 0;
		} finally {
			
			// Close the console scanner 
			consoleInput.close();
		}
	}

}
