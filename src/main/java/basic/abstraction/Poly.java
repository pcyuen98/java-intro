package basic.polymorphism;

// parent class
public interface Poly {

	public final String color = "green";
	public final String currency = "USD";
	public final Double balance = 1.0;

	public Double convertCurrency(String fromCurrency);
	

	public static void main(String[] args) {
		
		//Interface cannot be instantiated 
		//Poly poly = new Poly();

	}
}