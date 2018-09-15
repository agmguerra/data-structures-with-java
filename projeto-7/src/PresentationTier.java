import java.util.List;
import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void showBookTitlesByAuthor() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter part of author name to search: ");

	    String authorNamePart = scanner.next();

	    scanner.close();
	    
	    List<String> bookTitles = logicTier.findBookTitlesByAuthor(authorNamePart);
	    
	    bookTitles.forEach(str -> System.out.println(String.format("Book title %s", str)));	
	    		
	}
	
	public void showNumberOfBooksInYear() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.print("Enter year of publication to search: ");

	    int year = scanner.nextInt();
	    
	    int count = logicTier.findNumberOfBooksInYear(year);
	    
	    scanner.close();

	    
	    System.out.println(String.format("Total number of publications from year %d is %d", year, count));

	}
	
	public void start() {
		
		showBookTitlesByAuthor();
		showNumberOfBooksInYear();
		
	}
	

}
