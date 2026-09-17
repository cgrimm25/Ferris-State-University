/*
 * File: JavaAddLinkedListExample.java
 * Author: Chris Grimm
 * Date: 9/13/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 2 - (Read and Run Code Assignment)
 * Task 2
 * Reference:
 * https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/
 * Description: This program uses add(), addFirst() and addLast() 
 * methods to add the elements at the desired locations in the LinkedList.
*/

import java.util.*;

public class JavaAddLinkedListExample {
	public static void main(String args[]) {

		LinkedList<String> list = new LinkedList<String>();

		// Adding elements to the Linked list
		list.add("Steve");
		list.add("Carl");
		list.add("Raj");

		// Adding an element to the first position
		list.addFirst("Negan");

		// Adding an element to the last position
		list.addLast("Rick");

		// Adding an element to the 3rd position
		list.add(2, "Glenn");

		// Iterating LinkedList
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
