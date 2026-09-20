/*
 * File: List_Functions.java
 * Author: Chris Grimm
 * Date: 9/19/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 - Starting with Data Structures:Exploring Lists
 * Library Desktop App Using Lists
 * Description: Interface with list functions.
*/
package librarydesktopapp;

import java.util.List;

public interface List_Functions {
	
	// UI Table and Display Support
    int getSize();
    Book getBook(int index);
    List<Book> getFirstTen();

    // Search Operations (Binary for ArrayList, Linear for LinkedList)
    List<Book> searchList(String query);

    // Sorting Operations (value: "authors" or "year", ascending: true/false)
    void sortList(String field, boolean ascending);

    // CRUD / Extra Credit Operations
    void addBook(Book book);
    void importList(List<Book> list);
    void editList(Book newBook, int index);
    void deleteList(int index);
    
    
}
