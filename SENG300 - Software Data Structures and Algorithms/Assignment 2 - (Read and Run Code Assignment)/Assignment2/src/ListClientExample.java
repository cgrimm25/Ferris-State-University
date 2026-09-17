/*
 * File: ListClientExample.java
 * Author: Chris Grimm
 * Date: 9/13/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 2 - (Read and Run Code Assignment)
 * Task 1
 * Description: Demonstrates the principle of programming to an interface
*/

// import java.util.LinkedList; Commented out as using ArrayList instead
import java.util.List;
import java.util.ArrayList; // Added import statement 

public class ListClientExample {
	@SuppressWarnings("rawtypes")
	private List list;

	@SuppressWarnings("rawtypes")
	public ListClientExample() {
		list = new ArrayList(); // Changed from LinkedList() to ArrayList()
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	public static void main(String[] args) {
		ListClientExample lce = new ListClientExample();
		@SuppressWarnings("rawtypes")
		List list = lce.getList();
		System.out.println(list);
	}
}
