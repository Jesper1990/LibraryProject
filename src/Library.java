import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Library implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public void  removeItem(int productId) {														
		System.out.println("succesfully removed " +map.remove(productId).title);
		
	}
	public void infoItem(int productId) {
		if (map.containsKey(productId)) {
		 System.out.println(map.get(productId));
		}
	}

	public void borrowItem(int productId, Person person) {
		if (map.get(productId).borrowedBy == null) {
			map.get(productId).borrowedBy = person;
			System.out.println("Successfully lended " + map.get(productId).title + " to " + Person.name);
		} else {
			System.out.println(map.get(productId).title + " is already borrowed by " + Person.name);
		}
	}
	public void returnItem(int productId) {
		
		 if(!(map.get(productId).borrowedBy == null)) {
			map.get(productId).borrowedBy = null;
			System.out.println("Successfully returned " + map.get(productId).title + " from " + Person.name);
			
		 } else {
			 System.out.println("Cannot return " + map.get(productId).title + ". It is not borrowed by any customer.");
		 }
		
	}
	public void listPrint() {	
		
		map.forEach((key, value) -> {
			String itemType = " ";
			if(value instanceof Book) {
				itemType = "(book)"; 
			} else {
				itemType = "(movie)";
			}
			System.out.println(key + " " + itemType + " " + value.title + " " + value.borrowedBy);
		});
	
		
	
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
