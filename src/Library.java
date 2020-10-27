import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Serializable {
	
	private List<Book> books;
	private List<Movie> movies;
	
	
	public Library() {
		books = new ArrayList<Book>();
		movies = new ArrayList<Movie>();
		
	}
	public void addBook(Book book) {
		books.add(book);
	}
	public void addMovie(Movie m) {
		movies.add(m);
	}

	@Override
	public String toString() {
		String total = " ";
		Iterator<Book> i = books.iterator();
		while(i.hasNext()) {
			Book b = i.next();
			total = total + b.toString();
		}
		Iterator<Movie> m = movies.iterator();
		while(m.hasNext()) {
			Movie mov = m.next();
			total = total + mov.toString();
		}
		return total;
	}

}
