
public class Item {

	protected int productId;
	protected String title;
	protected int value;
	
	public Item() {
		productId = 0;
		title = null;
		value = 0;
	}
	
	public Item(int productId, String title, int value) {
		this.productId = productId;
		this.title = title;
		this.value = value;
	}
	@Override
	public String toString() {
		return productId + " " + title + " " + value;
	}

}
