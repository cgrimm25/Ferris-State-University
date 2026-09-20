/*
 * File: TestLists.java
 * Author: Chris Grimm
 * Date: 9/19/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 - Starting with Data Structures:Exploring Lists
 * Library Desktop App Using Lists
 * Description: Benchmarking tool comparing ArrayList Binary Search 
 *              vs LinkedList Linear Search (Requirements 9 & 10).
*/
package librarydesktopapp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestLists {

    public static void main(String[] args) {
        // 1. Point to CSV file (use books.csv or booksBig.csv)
        File csvFile = new File("Data\\booksBig.csv"); 
        System.out.println("Importing dataset: " + csvFile.getPath() + "...");

        ArrayList<Book> rawBooks = ImportCSV.importCSV(csvFile);
        System.out.println("Loaded " + rawBooks.size() + " books successfully.\n");

        if (rawBooks.isEmpty()) {
            System.out.println("Error: No books loaded. Check your CSV path.");
            return;
        }

        // 2. Populate both list implementations
        BookArrayList bookArrayList = new BookArrayList();
        bookArrayList.importList(rawBooks);

        BookLinkedList bookLinkedList = new BookLinkedList();
        bookLinkedList.importList(rawBooks);

        // 3. Requirement 9: Run separate benchmarking method (sample size: 500)
        runBenchmark(bookArrayList, bookLinkedList, rawBooks, 500);
    }

    /**
     * Requirement 9 & 10: Performance test comparing Binary Search on ArrayList
     * against Linear Search on LinkedList across a large sample of targets.
     */
    public static void runBenchmark(BookArrayList arrayList, BookLinkedList linkedList, List<Book> data, int sampleSize) {
        int count = Math.min(sampleSize, data.size());
        System.out.println("==================================================");
        System.out.println("       SEARCH PERFORMANCE BENCHMARK (N = " + count + ")");
        System.out.println("==================================================");

        // Extract a sample of book IDs directly from the dataset
        List<String> targetIds = new ArrayList<>();
        int step = Math.max(1, data.size() / count);
        for (int i = 0; i < data.size() && targetIds.size() < count; i += step) {
            targetIds.add(String.valueOf(data.get(i).getId()));
        }

        // Pre-sort ArrayList by ID so we measure pure Binary Search time
        arrayList.sortList("id", true);

        // --- 1. Benchmark Binary Search (BookArrayList) ---
        long startArray = System.nanoTime();
        int arrayHits = 0;
        for (String target : targetIds) {
            List<Book> res = arrayList.searchList(target);
            if (!res.isEmpty()) {
                arrayHits++;
            }
        }
        long endArray = System.nanoTime();
        double arrayDurationMs = (endArray - startArray) / 1_000_000.0;

        // --- 2. Benchmark Linear Search (BookLinkedList) ---
        long startLinked = System.nanoTime();
        int linkedHits = 0;
        for (String target : targetIds) {
            List<Book> res = linkedList.searchList(target);
            if (!res.isEmpty()) {
                linkedHits++;
            }
        }
        long endLinked = System.nanoTime();
        double linkedDurationMs = (endLinked - startLinked) / 1_000_000.0;

        // --- Requirement 10: Report Running Times ---
        System.out.printf("ArrayList (Binary Search):%n");
        System.out.printf(" - Total Search Time: %.4f ms%n", arrayDurationMs);
        System.out.printf(" - Average Time / Query: %.6f ms%n", (arrayDurationMs / count));
        System.out.printf(" - Successful Matches: %d / %d%n%n", arrayHits, count);

        System.out.printf("LinkedList (Linear Search):%n");
        System.out.printf(" - Total Search Time: %.4f ms%n", linkedDurationMs);
        System.out.printf(" - Average Time / Query: %.6f ms%n", (linkedDurationMs / count));
        System.out.printf(" - Successful Matches: %d / %d%n%n", linkedHits, count);

        double speedup = linkedDurationMs / (arrayDurationMs > 0 ? arrayDurationMs : 0.0001);
        System.out.printf("Result: Binary Search was %.2fx faster than Linear Search.%n", speedup);
        System.out.println("==================================================");
    }
}