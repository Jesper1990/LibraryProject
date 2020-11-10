import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static boolean isRunning;
	public static Library lib = new Library();
	private static String fileName = "library.txt";


	public static void main(String[] args) {	
		menu();
		readList();

		isRunning = true;

		while(isRunning) {
			String str = scanner.next();
			if(str.equals("register")) {
				System.out.println("Want to register a book (b) or movie (m) ?");

			} else if (str.equals("m")) {
				addMovie();
				addList();

			} else if (str.equals("b")) {
				addBook();
				addList();

			} else if (str.equals("list")) {
				listPrint();

			} else if (str.equals("checkout")) {
				borrowItem();
				addList();

			} else if (str.equals("checkin")) {
				returnItem();
				addList();

			} else if (str.equals("remove")) {
				removeItem();
				addList();

			} else if (str.equals("info")) {
				infoItem();

			} else if (str.equals("menu")) {
				menu();

			} else if (str.equals("quit")) {
				System.out.println("Exiting program! Thank you for using the library.");
				System.exit(0);

			} else {
				System.out.println("Unknown command, please use the menu for reference!");

			}
		}

	}

	public static void menu() {
		System.out.println("Welcome to the Library menu! " + "\n" + "\n" 
				+ "register - Will give you an option to register an item." + "\n" 
				+ "list - Will give you a display of the current library." + "\n"
				+ "checkout (id) - Lets you borrow an item of your choice with specified ID." + "\n"
				+ "checkin (id) - Lets you return your borrowed item with specified ID." + "\n" 
				+ "remove (id) - Will remove the item with specific ID" + "\n"
				+ "info (id) - Prints out the current information on the item with specified ID" + "\n"
				+ "quit - Exits the program.");

	}

	public static void addBook() {
		int productId;
		String title;
		int value; 
		int pages;
		String publisher;
		try {	
			System.out.println("Enter productID: ");
			productId = scanner.nextInt();
			String s = Integer.toString(productId);
			if(lib.checkId(productId)) {
				System.out.println("Error: Product with ID " + productId + " already exists!");			
			} else if (s.length() != 5) {
				System.out.println("Error: Product ID must be 5 digits!");
			} else {
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

				Book b = new Book(productId, title, value, pages, publisher);
				lib.addBook(b);
				System.out.println("Successfully registered " + title + "!"); }
		}	catch (InputMismatchException e){
			System.out.println("Unknown command, please try again.");
		}

	}
	public static void addMovie() {
		int productId = 0;
		String title;
		int value;
		int runLength; 
		float rating;		
		try {	
			System.out.println("Enter productID: ");
			productId = scanner.nextInt();
			String s = Integer.toString(productId);
			if(lib.checkId(productId)) {
				System.out.println("Error: Product with ID " + productId + " already exists!");			
			} else if (s.length() != 5) {
				System.out.println("Error: Product ID must be 5 digits!");
			} else {
				scanner.nextLine();
				System.out.println("Enter Title: " );
				title = scanner.nextLine();
				System.out.println("Enter Value: ");
				value = scanner.nextInt();
				System.out.println("Enter Runlength: ");
				runLength = scanner.nextInt();
				System.out.println("Enter Rating: ");
				rating = scanner.nextFloat();
				Movie m = new Movie(productId, title, value, runLength, rating);
				lib.addMovie(m);
				System.out.println("Successfully registered " + title + "!"); }
		} catch (InputMismatchException e){
			System.out.println("Unknown command, please try again.");
		}
	}

	public static void removeItem() {
		int productId;
		
		try {	
			productId = scanner.nextInt();
		if(lib.checkId(productId)) {
			lib.removeItem(productId);
		} else { System.out.println("Product does not exist."); }

		} catch(InputMismatchException e) {
			System.out.println("Unknown input, please enter ID number.");
		}

	}
	public static void infoItem() {
		int productId;
		try {	
			productId = scanner.nextInt();
		if (lib.checkId(productId)){
			lib.infoItem(productId);
		} else {
			System.out.println("Error: no product with ID " + productId + " registered.");}
		}
		catch(InputMismatchException e) {
			System.out.println("Unknown input, please enter ID number.");
		}
	}

	public static void listPrint() {
		lib.listPrint();
	}

	public static void borrowItem() {
		int productId;
		String name;
		String phoneNum;		
		try {
			productId = scanner.nextInt();

			if(lib.checkId(productId)) {
				scanner.nextLine();
				System.out.println("Enter your full name: ");
				name = scanner.nextLine();
				System.out.println("Enter your phone number: ");
				phoneNum = scanner.next();

				Person p = new Person(name, phoneNum);		
				lib.borrowItem(productId, p);

			} else {
				System.out.println("Product does not exist.");
			}		
		} catch (InputMismatchException e) {
			System.out.println("Unknown input, please enter ID number.");
		}
	}
	public static void returnItem() {

		int productId;		
		try {
			productId = scanner.nextInt();
			
			if(lib.checkId(productId)) {
				lib.returnItem(productId);
			} else {
				System.out.println("Product does not exist.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Unkown command, please enter ID.");
		}  

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
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}	
