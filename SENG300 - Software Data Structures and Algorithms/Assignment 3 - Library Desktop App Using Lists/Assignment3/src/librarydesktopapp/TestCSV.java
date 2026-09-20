package librarydesktopapp;

import java.io.File;
import java.util.ArrayList;

public class TestCSV {
    public static void main(String[] args) {
        // 1. Point to your CSV file. 
        // If it is in your main project folder, just the name works.
        File csvFile = new File("Data\\books.csv"); 

        System.out.println("Starting import...");

        // 2. Call your method to parse the file
        ArrayList<Book> myLibrary = ImportCSV.importCSV(csvFile);

        // 3. Verify the total count
        System.out.println("Import complete!");
        System.out.println("Total books loaded: " + myLibrary.size());

        // 4. Print the first 5 records to verify the data
        for (int i = 0; i < myLibrary.size(); i++) {
            Book b = myLibrary.get(i);
            
            // This triggers your custom toString() method in Book.java
            System.out.println((i + 1) + ". " + b.toString()); 
            
            // Print a few extra fields to prove the hardcoded indexes worked
            System.out.println("   Year: " + b.getOriginalPublicationYear() 
                             + " | Book ID: " + b.getId() 
                             + " | Image: " + b.getImageUrl());
        }
    }
}