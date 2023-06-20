package basic.inheritance;

//sub class Singapore
public class CardSG extends Card {

	// method name == class name is constructor
	// Compulsory Setting if parent class got constructor 
	public CardSG(String color) {
		super(color);
	}

	public static void main(String args[]) {
		
		// Parent is card
		Card card = new CardSG("pink");
		
		card.printCard();
	}

}
