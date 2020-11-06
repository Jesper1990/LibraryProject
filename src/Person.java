import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static String name;
	protected String phoneNum;
	
	public Person() {
		name = null;
		phoneNum = null;
	}
	public Person(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return name + " " + phoneNum;
	}
}
