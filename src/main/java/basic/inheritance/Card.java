package basic.inheritance;

// parent class
public class Card {
	private String value;
	private String username;
	private String color;

	// method name == class name is constructor
	// subclass must have a same constructor
	public Card(String color) {
		this.color = color;
	}
	
	// printCard can be used in sub class
	// method to be reused in Msia and Singapore
	protected String printCard() {
		System.out.println("Your card color is =" + color);
		return value;
	}

// only username is Zul then return value for data encapsulation/protection 
	public String getValue() {
		if (username == "Zul")
			return value;
		else {

			return null;
		}

	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}