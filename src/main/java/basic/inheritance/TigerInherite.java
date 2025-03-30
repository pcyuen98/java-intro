package basic.inheritance;

public class TigerInherite extends Animal {

	// constructor must follow the rules
	public TigerInherite(String species) {
		super(species);
	}

	public static void main(String args[]) {
		
		// Inheritance only
		Animal animal = new TigerInherite("tiger");
		
		// inherited all methods without polymorphism 
		animal.printSpecies();
		animal.printAbility();
	}
}
