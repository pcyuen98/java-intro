package basic.inheritance;

public class PlayCardSG {

	public static void main(String args[]) {
		
		// Parent is card
		GrandFather card = new CardSG("pink");
		card.setCurrency("SGD");
		card.setBalance(3.0);
		card.printCard();
		
		System.out.println("your balance is " + card.getBalanceInString());
	}
}
