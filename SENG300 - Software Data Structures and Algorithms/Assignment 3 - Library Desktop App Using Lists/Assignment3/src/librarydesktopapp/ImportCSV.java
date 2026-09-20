/*
 * File: ImportCSV.java
 * Author: Chris Grimm
 * Date: 9/19/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 - Starting with Data Structures:Exploring Lists
 * Library Desktop App Using Lists
 * Description: Imports a CSV of books and returns that as an array list of
 * 				books.
*/

package librarydesktopapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class ImportCSV {
	
	public static ArrayList<Book> importCSV(File csvFile) {
		ArrayList<Book> returnList = new ArrayList<>();
        String line;
		
        // Pattern to split by comma, but ignore commas enclosed in quotes
        final String REGEX = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        Pattern pattern = Pattern.compile(REGEX); // Compile before loop to save processing time
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            
	            while ((line = br.readLine()) != null) {
	            	try {
	                    // The -1 limit ensures empty trailing columns are kept in the array
	                    String[] bookData = pattern.split(line, -1);
	                    
	                    int id = Integer.parseInt(bookData[0]);
	                    String isbn = bookData[5];
	                    String authors = bookData[7].replace("\"", "").trim();
	                    
	                    // Handle years that are blank
	                    int year = 0;
	                    if (!bookData[8].isEmpty()) {
	                        year = (int) Double.parseDouble(bookData[8]);
	                    }
	                    
	                    String title = bookData[10].replace("\"", "").trim();
	                    
	                    // Handle blank average ratings
	                    double rating = 0.0;
	                    if (!bookData[12].isEmpty()) {
	                        rating = Double.parseDouble(bookData[12]);
	                    }
	                    
	                    String language = bookData[11];
	                    String imageUrl = bookData[21];

	                    Book newBook = new Book(id, isbn, authors, year, title, rating, language, imageUrl);
	                    returnList.add(newBook);

	                } catch (Exception parseException) {
	                    System.out.println("Skipping malformed row: " + line);
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("File reading error: " + e.getMessage());
	        }
	        
	        return returnList;
	    }
	}