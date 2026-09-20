/*
 * File: BookLinkedList.java
 * Date: 9/19/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 - Starting with Data Structures:Exploring Lists
 * Library Desktop App Using Lists
 * Description: Linked list object containing a list of Books.
 * 				Counterpart to the BookArrayList object.
*/
package librarydesktopapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookLinkedList implements List_Functions {

	private LinkedList<Book> linkedList = new LinkedList<Book>();

	@Override
	public void importList(List<Book> importList) {
		for (Book book : importList) {
			linkedList.add(book);
		}
	}

	@Override
	// Linear search by book_id or isbn (Req 6 & 8b), with Title/Author fallback (Req 11 Bonus)
	public List<Book> searchList(String id) {
		List<Book> result = new ArrayList<Book>();
		if (id == null || id.trim().isEmpty() || linkedList.isEmpty()) {
			return result;
		}

		String query = id.trim();
		Integer targetId = null;

		try {
			targetId = Integer.parseInt(query);
		} catch (NumberFormatException e) {
			// Query is not an integer; check ISBN
		}

		// Requirement 8b: Linear search traversing the linked list
		for (Book book : linkedList) {
			if (targetId != null && book.getId() == targetId) {
				result.add(book);
				return result;
			}
			if (book.getIsbn() != null && book.getIsbn().equalsIgnoreCase(query)) {
				result.add(book);
				return result;
			}
		}

		// Requirement 11 Bonus: Title and Author search fallback
		for (Book book : linkedList) {
			if ((book.getTitle() != null && book.getTitle().toLowerCase().contains(query.toLowerCase())) ||
			    (book.getAuthor() != null && book.getAuthor().toLowerCase().contains(query.toLowerCase()))) {
				result.add(book);
			}
		}

		return result;
	}

	@Override
	// Sorts list by authors, year, id, or isbn in ascending or descending order (Req 7)
	public void sortList(String value, boolean value2) {
		if (value == null || linkedList.isEmpty()) {
			return;
		}

		if (value.equalsIgnoreCase("authors") || value.equalsIgnoreCase("author")) {
			linkedList.sort((b1, b2) -> {
				String a1 = (b1.getAuthor() != null) ? b1.getAuthor() : "";
				String a2 = (b2.getAuthor() != null) ? b2.getAuthor() : "";
				int res = a1.compareToIgnoreCase(a2);
				return value2 ? res : -res;
			});
		} else if (value.equalsIgnoreCase("year") || value.equalsIgnoreCase("originalPublicationYear")) {
			linkedList.sort((b1, b2) -> {
				int res = Integer.compare(b1.getOriginalPublicationYear(), b2.getOriginalPublicationYear());
				return value2 ? res : -res;
			});
		} else if (value.equalsIgnoreCase("id") || value.equalsIgnoreCase("bookid")) {
			linkedList.sort((b1, b2) -> {
				int res = Integer.compare(b1.getId(), b2.getId());
				return value2 ? res : -res;
			});
		} else if (value.equalsIgnoreCase("isbn")) {
			linkedList.sort((b1, b2) -> {
				String s1 = (b1.getIsbn() != null) ? b1.getIsbn() : "";
				String s2 = (b2.getIsbn() != null) ? b2.getIsbn() : "";
				int res = s1.compareToIgnoreCase(s2);
				return value2 ? res : -res;
			});
		}
	}

	// Create (Req 11 - Extra Credit) - Insert at top so it appears in Top 10 immediately
	@Override
	public void addBook(Book book) {
		linkedList.addFirst(book);
	}

	// Read
	@Override
	public Book getBook(int index) {
		if (index >= 0 && index < linkedList.size()) {
			return linkedList.get(index);
		}
		return null;
	}

	// Update
	@Override
	public void editList(Book newBook, int index) {
		if (index >= 0 && index < linkedList.size()) {
			linkedList.set(index, newBook);
		}
	}

	// Delete
	@Override
	public void deleteList(int index) {
		if (index >= 0 && index < linkedList.size()) {
			linkedList.remove(index);
		}
	}

	@Override
	public List<Book> getFirstTen() {
		List<Book> firstTen = new ArrayList<Book>();
		for (int i = 0; i < 10 && i < this.getSize(); i++) {
			firstTen.add(this.getBook(i));
		}
		return firstTen;
	}

	@Override
	public int getSize() {
		return linkedList.size();
	}

}