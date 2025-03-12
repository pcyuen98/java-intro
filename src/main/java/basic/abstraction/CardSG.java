package basic.inheritance;

//sub class Singapore
public class CardSG extends GrandFather {

	// method name == class name is constructor
	// Compulsory Setting if parent class got constructor 
	public CardSG(String color) {
		super(color);
	}

	protected String printCard() {
		System.out.println("Your customized card color is =" + this.getColor());
		return this.getValue();
	}

//	protected String getBalanceInString() {
//		return this.getCurrency() + " " + this.getBalance() ;
//	}
	
	public static void main(String args[]) {
		
		// Parent is card
		GrandFather card = new CardSG("pink");
		
		card.printCard();
	}

}
