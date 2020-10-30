

public class Book extends Item{

	private int pages;
	private String publisher;
	
	public Book() {
		super();
		pages = 0;
		publisher = null;
	}
	public Book (int productId, String title, int value, int pages, String publisher) {
		super(productId, title, value);
		this.pages = pages;
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return super.productId + " " + "(Book)" + " " +  super.title + " " + super.value + " " + pages + " " + publisher + "\n";
	}
}
