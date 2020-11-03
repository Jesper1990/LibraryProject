import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static boolean isRunning;
	public static Library lib = new Library();
	private static String fileName = "library.txt";


	public static void main(String[] args) {
		System.out.println("Wanna register a book (b) or movie (m) ?");
		
		
		isRunning = true;

		while(isRunning) {
			String str = scanner.next();
			if(str.equals("b")) {
				addBook();
				System.out.println("Wanna register a book (b) or movie (m) ?");
			}
			else if (str.equals("m")) {
				addMovie();
				System.out.println("Wanna register a book (b) or movie (m) ?");
			} else if (str.equals("save")) {
				addList();
			} else if (str.equals("read")) {
				readList();
			} else if (str.equals("list")) {
				try {
					listPrint();
				} catch (StackOverflowError e) {
					System.out.println("Stack error");
				}
			} else if (str.equals("checkout")) {
				borrowItem();
			} else if (str.equals("remove")) {
				removeItem();
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
		scanner.nextLine();
		System.out.println("Enter Title: " );
		title = scanner.nextLine();
		System.out.println("Enter Value: ");
		value = scanner.nextInt();
		System.out.println("Enter Pages: ");
		pages = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Publisher: ");
		publisher = scanner.nextLine();
		
		if(lib.checkId(productId)) {
			System.out.println("Error: Product with ID " + productId + " already exists!");			
		} else {
			Book b = new Book(productId, title, value, pages, publisher);
			lib.addBook(b);
			System.out.println("Successfully registered " + title + "!");
			
		}

	}
	public static void addMovie() {
		int productId;
		String title;
		int value;
		int runLength; 
		float rating;

		System.out.println("Enter productID: ");
		productId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Title: " );
		title = scanner.nextLine();
		System.out.println("Enter Value: ");
		value = scanner.nextInt();
		System.out.println("Enter Runlength: ");
		runLength = scanner.nextInt();
		System.out.println("Enter Rating: ");
		rating = scanner.nextFloat();

		if(lib.checkId(productId)) {
			System.out.println("Error: Product with ID " + productId + " already exists!");			
		} else {
			Movie m = new Movie(productId, title, value, runLength, rating);
			lib.addMovie(m);
			System.out.println("Successfully registered " + title + "!");
			
		}
				
	}
	public static void removeItem() {
		int productId;
		System.out.println("Enter the product ID of the item you wanna remove: ");
		
		productId = scanner.nextInt();
		
		lib.removeItem(productId);
	}
	
	public static void listPrint() {
		listPrint();
	}
	
	public static void borrowItem() {
		int productId;
		String name;
		String phoneNum;
		System.out.println("Enter the product ID of the item you wanna borrow: ");
		productId = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter your full name: ");
		name = scanner.nextLine();
		System.out.println("Enter your phone number: ");
		phoneNum = scanner.next();
				
		Person p = new Person(name, phoneNum);		
		lib.borrowItem(productId, p);			
	}
	public static void returnItem() {
		int productId;
		System.out.println("Enter the product ID of the item you wanna return: ");
		productId = scanner.nextInt();
		
	}
	
	public static void addList() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(lib);
			oos.close();
		} catch(Exception e ) {
			e.printStackTrace();
			return;
		}
	}
	public static void readList() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			lib = (Library) ois.readObject();
			System.out.println(lib);			
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}	
