
public class Movie extends Item{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int runLength; 
	private float rating;
	
	
	public Movie() {
		super();
		runLength = 0;
		rating = 0.0f;
		
	}
	public Movie (int productId, String title, int value, int runLength, float rating) {
		
		super(productId, title, value);
		this.runLength = runLength;
		this.rating = rating;
		
	}
	@Override
	public String toString() {
		return super.productId + " " + "(Movie)" + " " +  super.title + ": " + super.value + "kr, " + runLength + "min, rating " + rating  + "\n";
	}

}