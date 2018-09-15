import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	public List<String> findBookTitlesByAuthor(String author) {
		
		List<Book> books = dataTier.getAllBooks();
		
		List<String> bookTitles = new ArrayList<String>();
		books.forEach(book -> {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				bookTitles.add(book.getTitle());
			}
		});
		
		
		return bookTitles;
	}

	public int findNumberOfBooksInYear(int year) {
		
		List<Book> books = dataTier.getAllBooks();
		
		long numOfBooksInYear = books.stream().filter(book -> book.getPublicationYear() == year).count();
		
		return (int)numOfBooksInYear;
	}
}
