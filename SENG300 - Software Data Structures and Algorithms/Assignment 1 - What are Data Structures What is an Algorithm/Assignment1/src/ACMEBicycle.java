/*
 * File: ACMEBicycle.java
 * Author: Chris Grimm
 * Date: 9/8/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 1 - Running your First Algorithm
 * Task 1
 * Reference: https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
 * Description: A class implementing the Bicycle interface to track and modify the current state
 * of the ACME bicycle.
*/

public class ACMEBicycle implements Bicycle {
	int cadence = 0;
    int speed = 0;
    int gear = 1;

    public void changeCadence(int newValue) {
         cadence = newValue;
    }

    public void changeGear(int newValue) {
         gear = newValue;
    }

    public void speedUp(int increment) {
         speed = speed + increment;
    }

    public void applyBrakes(int decrement) {
         speed = speed - decrement;
    }

    void printStates() {
         System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
    }

}
