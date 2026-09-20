/*
 * File: SelectionSort.java
 * Author: Chris Grimm
 * Date: 9/6/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 1 - Running your First Algorithm
 * Task 3
 * References:
 * Java System.currentTimeMillis()
 *   https://jenkov.com/tutorials/java-date-time/system-currenttimemillis.html
 * Java Time Measurement
 *   https://jenkov.com/tutorials/java-date-time/time-measurement.html
 * Description: Triggers the number generator, reads the resulting text file into an array,
 * sorts the integers using the selection sort algorithm, and calculates the execution time in
 * milliseconds.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
// import java.util.Arrays; Commented out as using Linked List
import java.util.List;
import java.util.Scanner;

public class SelectionSort {

	/**
	 * Swaps the elements at indexes i and j.
	 */
	public static void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/**
	 * Finds the index of the lowest value
	 * between indices low and high (inclusive).
	 */
	public static int indexLowest(int[] array, int start) {
		int lowIndex = start;
		for (int i = start; i < array.length; i++) {
			if (array[i] < array[lowIndex]) {
				lowIndex = i;
			}
		}
		return lowIndex;
	}

	/**
	 * Sorts the cards (in place) using selection sort.
	 */
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = indexLowest(array, i);
			swapElements(array, i, j);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int generatedCount = NumberGenerator.generate();
		
		// Define file and create a dynamic list that can grow up to 100,000 entries
		String filename = "numbers.txt";
		List<Integer> numberList = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(new File(filename))) {
			while (scanner.hasNextInt()) {
				numberList.add(scanner.nextInt());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: Could not locate the file '" + filename + "'.'");
			return;
		}
		
		// Convert the dynamic list back into a primitive int[] array
		int[] array = new int[numberList.size()];
		for (int i =0; i < numberList.size(); i++) {
			array[i] = numberList.get(i);
		}
		
		// Record the start time
		long startTime = System.currentTimeMillis();
		
		// Run the selection sort
		selectionSort(array);
		
		// Record the end time and calculate the duration
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		
		// Output the results
		System.out.println("--------------------------------------------------");
		System.out.println("Records generated and sorted: " + generatedCount);
		System.out.println("Selection sort execution time: " + duration + " milliseconds");
		System.out.println("Timestamp: " + new java.util.Date());
		// Commented out to prevent list of numbers flooding console
		// System.out.println(Arrays.toString(array));
	}

}
