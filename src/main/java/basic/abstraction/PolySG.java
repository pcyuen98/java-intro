package basic.polymorphism;

public class PolySG implements Poly {

	public String color = "blue";
	public String currency;
	public Double balance;

	public PolySG() {
	}
	
	public PolySG(String color) {
		this.color = color;
	}
	
	@Override
	public Double convertCurrency(String fromCurrency) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main (String args[]) {
		PolySG polySG = new PolySG("new");
		System.out.println("PolySG:" + polySG.getColor());
		
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
