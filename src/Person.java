import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String phoneNum;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
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
		return "\n    " + "Borrowed by: " + name + ", " + phoneNum;
	}
}
