import java.io.Serializable;

public class Movie implements Serializable{
	private int productId;
	private String title;
	private int value;
	private int runLength; 
	private float rating;
	
	
	public Movie() {
		productId = 0;
		title = null;
		value = 0;
		runLength = 0;
		rating = 0.0f;
		
	}
	public Movie (int productId, String title, int value, int runLength, float rating) {
		
		this.productId = productId;
		this.title = title;
		this.value = value;
		this.runLength = runLength;
		this.rating = rating;
		
	}
	@Override
	public String toString() {
		return productId + " " +  title + " " +  value + " " + runLength + " " + rating;
	}

}