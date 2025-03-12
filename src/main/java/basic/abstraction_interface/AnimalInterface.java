package basic.abstraction_interface;

// parent class
public interface AnimalInterface {

	// for inheritance learning purposes
	public static final String TYPE = "CARNIVOR";

	// define rule no.1 - Child class must implement the below
	public void printSpecies();
	
	// Quiz: Explain why error below?
	//public void printAbility() { }
	
	public static void main(String[] args) {

		// Quiz: Explain why error below?
		// AnimalInterface animal = new AnimalInterface();
	}
	
}