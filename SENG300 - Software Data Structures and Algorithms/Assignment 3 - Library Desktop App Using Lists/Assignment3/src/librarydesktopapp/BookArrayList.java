/*
 * File: BookArrayList.java
 * Author: Chris Grimm
 * Date: 9/19/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 - Starting with Data Structures:Exploring Lists
 * Library Desktop App Using Lists
 * Description: ArrayList objects that contains a list of books.
 * 				counterpart to the BookLinkedList object.
*/

package librarydesktopapp;

import java.util.ArrayList;
import java.util.List;

public class BookArrayList implements List_Functions {

	private ArrayList<Book>arrayList=new ArrayList<Book>();

	@Override
	// imports importList's contents into list
	public void importList(List<Book> importList) {
		for (Book book : importList) {
			arrayList.add(book);
		}
	}

	@Override
	// Binary search by book_id or isbn (Req 6 & 8a), with Title/Author fallback
	// (Req 11 Bonus)
	public List<Book> searchList(String id) {
		ArrayList<Book> result = new ArrayList<Book>();
		if (id == null || id.trim().isEmpty() || arrayList.isEmpty()) {
			return result;
		}

		String query = id.trim();

		// 1. If input is a numeric ID, binary search by bookId
		try {
			int targetId = Integer.parseInt(query);

			// Binary search requires the list to be sorted by ID first
			arrayList.sort((b1, b2) -> Integer.compare(b1.getId(), b2.getId()));

			int low = 0;
			int high = arrayList.size() - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				int midId = arrayList.get(mid).getId();

				if (midId == targetId) {
					result.add(arrayList.get(mid));
					return result;
				} else if (midId < targetId) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		} catch (NumberFormatException e) {
			// Query is not an integer, move on to ISBN search
		}

		// 2. Binary search by ISBN
		arrayList.sort((b1, b2) -> {
			String s1 = (b1.getIsbn() != null) ? b1.getIsbn() : "";
			String s2 = (b2.getIsbn() != null) ? b2.getIsbn() : "";
			return s1.compareToIgnoreCase(s2);
		});

		int low = 0;
		int high = arrayList.size() - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			String midIsbn = (arrayList.get(mid).getIsbn() != null) ? arrayList.get(mid).getIsbn() : "";
			int cmp = midIsbn.compareToIgnoreCase(query);

			if (cmp == 0) {
				result.add(arrayList.get(mid));
				return result;
			} else if (cmp < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		// 3. Extra Credit: Title and Author search fallback if ID/ISBN does not match
		for (Book b : arrayList) {
			if ((b.getTitle() != null && b.getTitle().toLowerCase().contains(query.toLowerCase()))
					|| (b.getAuthor() != null && b.getAuthor().toLowerCase().contains(query.toLowerCase()))) {
				result.add(b);
			}
		}

		return result;
	}

	@Override
	// Sorts list by authors, year, id, or isbn in ascending or descending order
	// (Req 7)
	public void sortList(String value, boolean value2) {
		if (value == null || arrayList.isEmpty()) {
			return;
		}

		if (value.equalsIgnoreCase("authors") || value.equalsIgnoreCase("author")) {
			arrayList.sort((b1, b2) -> {
				String a1 = (b1.getAuthor() != null) ? b1.getAuthor() : "";
				String a2 = (b2.getAuthor() != null) ? b2.getAuthor() : "";
				int res = a1.compareToIgnoreCase(a2);
				return value2 ? res : -res;
			});
		} else if (value.equalsIgnoreCase("year") || value.equalsIgnoreCase("originalPublicationYear")) {
			arrayList.sort((b1, b2) -> {
				int res = Integer.compare(b1.getOriginalPublicationYear(), b2.getOriginalPublicationYear());
				return value2 ? res : -res;
			});
		} else if (value.equalsIgnoreCase("id") || value.equalsIgnoreCase("bookid")) {
			arrayList.sort((b1, b2) -> {
				int res = Integer.compare(b1.getId(), b2.getId());
				return value2 ? res : -res;
			});
		} else if (value.equalsIgnoreCase("isbn")) {
			arrayList.sort((b1, b2) -> {
				String s1 = (b1.getIsbn() != null) ? b1.getIsbn() : "";
				String s2 = (b2.getIsbn() != null) ? b2.getIsbn() : "";
				int res = s1.compareToIgnoreCase(s2);
				return value2 ? res : -res;
			});
		}
	}

	// Create (Req 11 - Extra Credit) - Insert at index 0 so it immediately appears
	// in the Top 10
	@Override
	public void addBook(Book book) {
		arrayList.add(0, book);
	}

	// Read
	@Override
	public Book getBook(int index) {
		if (index >= 0 && index < arrayList.size()) {
			return arrayList.get(index);
		}
		return null;
	}

	// Update
	@Override
	public void editList(Book newBook, int index) {
		if (index >= 0 && index < arrayList.size()) {
			arrayList.set(index, newBook);
		}
	}

	// Delete
	@Override
	public void deleteList(int index) {
		if (index >= 0 && index < arrayList.size()) {
			arrayList.remove(index);
		}
	}

	@Override
	// gets first ten book objects
	public List<Book> getFirstTen() {
		List<Book> firstTen = new ArrayList<Book>();
		for (int i = 0; i < 10 && i < this.getSize(); i++) {
			firstTen.add(this.getBook(i));
		}
		return firstTen;
	}

	@Override
	public int getSize() {
		return arrayList.size();
	}

}