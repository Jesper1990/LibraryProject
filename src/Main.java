import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String str = scanner.next();
		ArrayList<Data> arr = new ArrayList<Data>();
		Data a = new Data(12345, "(Book): ", "To kill a Mockingbird. ", "(in stock)");
		Data b = new Data(12346, "(Book): ", "The great gatsby. ", "(in stock)");
		Data c = new Data(12347, "(Movie): ", "Godzilla. ", "(in stock)");
		Data d = new Data(12348, "(Book): ", "The hobbit. ", "(in stock)");
		arr.add(a);
		arr.add(b);
		arr.add(c);
		arr.add(d);
		if (str.equals("list")) {
			for (Data s : arr) {
				System.out.println(s);
				continue;
			}							
		} else {
			System.out.println("Avslutar programmet.");
			System.exit(0);
		}
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