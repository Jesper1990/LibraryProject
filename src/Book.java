import java.io.Serializable;

public class Book implements Serializable{
	private int productId;
	private String title; 
	private int value; 
	private int pages;
	private String publisher;
	
	public Book() {
		productId = 0;
		title = null;
		value = 0;
		pages = 0;
		publisher = null;
	}
	public Book (int productId, String title, int value, int pages, String publisher) {
		
		this.productId = productId;;
		this.title = title;
		this.value = value;
		this.pages = pages;
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return productId + " " +  title + " " +  value + " " +  pages + " " + publisher;
	}

}
