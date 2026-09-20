/*
 * File: Bicycle.java
 * Author: Chris Grimm
 * Date: 9/8/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 1 - Running your First Algorithm
 * Task 1
 * Reference: https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
 * Description: An interface defining the core behaviors of a bicycle
*/

public interface Bicycle {
	
	// wheel revolutions per minute
    void changeCadence(int newValue);
    
    void changeGear(int newValue);
    
    void speedUp(int increment);
    
    void applyBrakes(int decrement);

}
