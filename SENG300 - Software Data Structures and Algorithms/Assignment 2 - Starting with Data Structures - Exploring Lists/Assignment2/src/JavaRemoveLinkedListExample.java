/*
 * File: JavaRemoveLinkedListExample.java
 * Author: Chris Grimm
 * Date: 9/13/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 2 - (Read and Run Code Assignment)
 * Task 2
 * Reference:
 * https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/
 * Description: This program uses a few popular remove methods for LinkedList
 * that are used to remove elements from certain positions.
*/
import java.util.*;

public class JavaRemoveLinkedListExample {
	public static void main(String args[]) {

		LinkedList<String> list = new LinkedList<String>();

		// Adding elements to the Linked list
		list.add("Steve");
		list.add("Carl");
		list.add("Raj");
		list.add("Negan");
		list.add("Rick");

		// Removing First element
		// Same as list.remove(0);
		list.removeFirst();

		// Removing Last element
		list.removeLast();

		// Iterating LinkedList
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		// removing 2nd element, index starts with 0
		list.remove(1);

		System.out.print("\nAfter removing second element: ");
		// Iterating LinkedList again
		Iterator<String> iterator2 = list.iterator();
		while (iterator2.hasNext()) {
			System.out.print(iterator2.next() + " ");
		}
	}
}
