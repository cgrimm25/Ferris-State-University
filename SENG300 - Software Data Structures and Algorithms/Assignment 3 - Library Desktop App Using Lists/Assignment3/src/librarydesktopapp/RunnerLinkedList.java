/*
 * File: runnerArrayList.java
 * Author: Chris Grimm
 * Date: 9/14/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 Library Desktop App Using Lists
 * Description: Runs program using LinkedLists.
*/

package librarydesktopapp;

import java.io.File;
import java.io.IOException;

public class RunnerLinkedList {
    public static void main(String[] args) throws IOException {
        // setup linked list
        File csv = new File("Data\\booksBig.csv");
        BookLinkedList bookList = new BookLinkedList();
        bookList.importList(ImportCSV.importCSV(csv));

        new LibraryManagerGUI(bookList);
    }
}