import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Serializable {
	
	private List<Item> items;
	
	
	public Library() {
		items = new ArrayList<Item>();
		
	}
	public void addBook(Item item) {
		items.add(item);
	}
	public void addMovie(Item item) {
		items.add(item);
	}


	@Override
	public String toString() {
		String total = " ";
		Iterator<Item> i = items.iterator();
		while(i.hasNext()) {
			Item it = i.next();
			total = total + it.toString();
		}

		return total;
	}


}
