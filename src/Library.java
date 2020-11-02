import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Library implements Serializable {
	
	private HashMap<Integer, Item> map;
	
	
	public Library() {
		map = new HashMap<>();
		
	}
	public void addBook(Item item) {
		map.put(item.productId, item);
	}
	public void addMovie(Item item) {
		map.put(item.productId, item);
	}
	public boolean checkId(int productId) {
		if(map.containsKey(productId)) {
			return true;
		}
		return false;
	}
	public void borrowItem(int productId, Person person) {
		if (map.get(productId).borrowedBy == null) {
			map.get(productId).borrowedBy = person;
			System.out.println("Successfully lended " + map.get(productId) + " to " + person);
		} else {
			System.out.println("Book is already borrowed");
		}
	}
	public void returnItem(int productId, Person person) {
		if(!(map.get(productId).borrowedBy == null)) {
			map.get(productId).borrowedBy = null;
			System.out.println("Successfully returned " + map.get(productId) + " from " + person);
		} else {
			System.out.println("Cannot return. It is already borrowed.");
		}
	}
	
	@Override
	public String toString() {
		String total = "";
		Iterator<Entry<Integer, Item>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Entry<Integer, Item> i = it.next();
			total = total + i.getValue();
		}
		return total;
	}
}
