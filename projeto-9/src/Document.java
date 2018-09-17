import java.util.Date;

public abstract class Document {
	
	private String title;
	private String author;
	private Date date;
	private PublishingLocation publishingLocation;
	
	public Document(String title, String author, Date date, PublishingLocation publishingLocation) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.publishingLocation = publishingLocation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getCity() {
		return this.publishingLocation.getCity();
	}
	
	public String getState() {
		return this.publishingLocation.getState();
	}
	
	public String getPostCode() {
		return this.publishingLocation.getPostCode();
	}
	
	public boolean sameAuthor(Document document){
		return this.author.equals(document.getAuthor());
	}

	public int compareDates(Document document){
		return this.date.compareTo(document.getDate());
	}
	
	public int compareWithGeneralDate(Date date){
		return this.date.compareTo(date);
	}


}
