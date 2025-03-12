package basic.inheritance;

// parent class
public class GrandFather {
	
	// for inheritance learning purposes
	private String race;
	private String currency;
	private Double balance;
	
	// for encapsulation learning purposes
	private String value;
	private String username;
	
	// method name == class name is constructor
	// subclass must have a same constructor
	public GrandFather(String color) {
		this.race = color;
	}
	
	// printCard can be used in sub class
	// method to be reused in Msia and Singapore
	protected String printCard() {
		System.out.println("Your card color is =" + race);
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
	
	protected String getBalanceInString() {
		return this.balance + " " + this.currency;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getColor() {
		return race;
	}

	public void setColor(String color) {
		this.race = color;
	}
	

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public static void main(String[] args) {
		
		GrandFather card = new GrandFather("default");
		card.setCurrency("USD");
		card.setBalance(1.0);
		card.printCard();
		
		System.out.println("your balance is " + card.getBalanceInString());

	}
}