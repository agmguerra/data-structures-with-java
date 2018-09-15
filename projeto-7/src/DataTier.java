import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public List<Book> getAllBooks() {
		
		if (fileName == null || fileName.isEmpty()) {
			return null;
		}
		
		List<Book> books = null;
		
		Path file = Paths.get(fileName);
		try {
			List<String> lines = Files.readAllLines(file);
			if (lines == null || lines.isEmpty()) {
				return null;
			}
			
			books = new LinkedList<Book>();
			
			for (String line : lines) {
				String[] lineParts = line.split("\t");
				books.add(new Book(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2])));
				
			}
			
		} catch (IOException e) {
			return null;
		}
		
		return books;
	}

}
