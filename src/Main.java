import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static boolean isRunning;
	public static Library lib = new Library();


	public static void main(String[] args) {
		System.out.println("Wanna register a book (b) or movie (m) ?");
		
		
		isRunning = true;

		while(isRunning) {
			String str = scanner.next();
			if(str.equals("b")) {
				addBook();
			}
			else if (str.equals("m")) {
				addMovie();
			}
		}

	}

	public static void addBook() {
		int productId;
		String title; 
		int value; 
		int pages;
		String publisher;

		System.out.println("Enter productID: ");
		productId = scanner.nextInt();
		System.out.println("Enter Title: " );
		title = scanner.next();
		System.out.println("Enter Value: ");
		value = scanner.nextInt();
		System.out.println("Enter Pages: ");
		pages = scanner.nextInt();
		System.out.println("Enter Publisher: ");
		publisher = scanner.next();

		Book b = new Book(productId, title, value, pages, publisher);
		lib.addBook(b);
		System.out.println(lib);
	}
	public static void addMovie() {
		int productId;
		String title;
		int value;
		int runLength; 
		float rating;

		System.out.println("Enter productID: ");
		productId = scanner.nextInt();
		System.out.println("Enter Title: " );
		title = scanner.next();
		System.out.println("Enter Value: ");
		value = scanner.nextInt();
		System.out.println("Enter Runlength: ");
		runLength = scanner.nextInt();
		System.out.println("Enter Rating: ");
		rating = scanner.nextFloat();

		Movie m = new Movie(productId, title, value, runLength, rating); 
		lib.addMovie(m);
		System.out.println(lib);

	}
}	
/* Vad skall göras? = Ett förenklat lagersystem som skall användas utav ett bibliotek.
* Product = Book / Movie (String)
* ------------------
* Article Number (Integer)
* Product Name (String)
* Value in kronor (Integer)
* --------------------
* Book properties = 
* Number of pages (Integer)
* Publisher (String)
* ---------------------
* Movie properties = 
* Length in minutes(Integer)
* Rating on IMDB (Float 0-10f)
* ---------------------
* Customer = 
* Name(String)
* Phone number (String)
*/