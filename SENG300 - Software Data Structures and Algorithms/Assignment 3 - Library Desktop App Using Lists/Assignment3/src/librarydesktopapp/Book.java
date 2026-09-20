/*
 * File: Book.java
 * Author: Chris Grimm
 * Date: 9/19/26
 * Institution: Ferris State University
 * SENG300: Software Data Structures and Algorithms
 * Assignment 3 - Starting with Data Structures:Exploring Lists
 * Library Desktop App Using Lists
 * Description: Data Structure reflecting a library book record.
*/

package librarydesktopapp;

public class Book implements Comparable<Book> {
	
	// Identifiers                       CSV Column Names & Indexes
	private int bookId;                  // [Index 0]  book_id
    private int goodreadsBookId;         // [Index 1]  goodreads_book_id
    private int bestBookId;              // [Index 2]  best_book_id
    private int workId;                  // [Index 3]  work_id
    private int booksCount;              // [Index 4]  books_count

    // Publication Info
    private String isbn;                 // [Index 5]  isbn
    private String isbn13;               // [Index 6]  isbn13
    private String authors;              // [Index 7]  authors
    private int originalPublicationYear; // [Index 8]  original_publication_year
    private String originalTitle;        // [Index 9]  original_title
    private String title;                // [Index 10] title
    private String languageCode;         // [Index 11] language_code

    // Ratings & Reviews
    private double averageRating;        // [Index 12] average_rating
    private int ratingsCount;            // [Index 13] ratings_count
    private int workRatingsCount;        // [Index 14] work_ratings_count
    private int workTextReviewsCount;    // [Index 15] work_text_reviews_count
    private int ratings1;                // [Index 16] ratings_1
    private int ratings2;                // [Index 17] ratings_2
    private int ratings3;                // [Index 18] ratings_3
    private int ratings4;                // [Index 19] ratings_4
    private int ratings5;                // [Index 20] ratings_5

    // Image Links
    private String imageUrl;             // [Index 21] image_url
    private String smallImageUrl;        // [Index 22] small_image_url
    
    // Constructors
    public Book(int bookId, String isbn, String authors, int originalPublicationYear, String title, double averageRating, String languageCode, String imageUrl) {
        this.bookId                  = bookId;
        this.isbn                    = isbn;
        this.authors                 = authors;
        this.originalPublicationYear = originalPublicationYear;
        this.title                   = title;
        this.averageRating           = averageRating;
        this.languageCode            = languageCode;
        this.imageUrl                = imageUrl;
    }
     
    // Default natural ordering by bookId (needed for binary search)
    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }
    
    // Methods
    public int    getId()       { return bookId;        }
    public String getIsbn()     { return isbn;          }
    public String getTitle()    { return title;         }
    public String getAuthor()   { return authors;       }
    public double getRating()   { return averageRating; }
    public String getLanguage() { return languageCode;  }
    public String getImageUrl() { return imageUrl;      }
    public int getOriginalPublicationYear() { return originalPublicationYear; }
    
    public void setId      (int    bookId       ) { this.bookId        = bookId;        }
    public void setIsbn    (String isbn         ) { this.isbn          = isbn;          }
    public void setTitle   (String title        ) { this.title         = title;         }
    public void setAuthor  (String authors      ) { this.authors       = authors;       }
    public void setRating  (double averageRating) { this.averageRating = averageRating; }
    public void setLanguage(String languageCode ) { this.languageCode  = languageCode;  }
    public void setImageUrl(String imageUrl     ) { this.imageUrl      = imageUrl;      }
    public void setOriginalPublicationYear(int originalPublicationYear) {this.originalPublicationYear = originalPublicationYear; }
    
   

    @Override
    public String toString() {
        return title + " by " + authors + " (" + averageRating + "★)";
    }
}