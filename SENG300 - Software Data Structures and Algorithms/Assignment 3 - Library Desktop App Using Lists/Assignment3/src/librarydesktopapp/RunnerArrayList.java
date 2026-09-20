/*
 * File: runnerArrayList.java
 * Author: Chris Grimm
 * Date: 9/14/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 Library Desktop App Using Lists
 * Description: Runs program using ArrayLists.
*/
package librarydesktopapp;

import java.io.File;
import java.io.IOException;

public class RunnerArrayList{
	public static void main(String[] args) throws IOException {
		//setup array
		File csv = new File("Data\\booksBig.csv");
		BookArrayList bookList = new BookArrayList();
		bookList.importList(ImportCSV.importCSV(csv));

		new LibraryManagerGUI(bookList);
		
		
	}
}
