/*
 * File: BicycleDemo.java
 * Author: Chris Grimm
 * Date: 9/8/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 1 - Running your First Algorithm
 * Task 1
 * Description: A test class to verify the Bicycle and ACMEBicycle interfaces work.
*/

public class BicycleDemo {
	
	public static void main(String[] args) {
		
		// Create new ACMEBicylce object
		ACMEBicycle mybike = new ACMEBicycle();
		
		// Call methods defined by Bicycle interface
		mybike.changeCadence(60);
		mybike.speedUp(25);
		mybike.changeGear(2);
		
		// Show results on console
		mybike.printStates();
		
		// apply brakes and show results
		mybike.applyBrakes(5);
		mybike.printStates();
	}

}
