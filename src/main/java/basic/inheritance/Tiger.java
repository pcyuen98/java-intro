package basic.inheritance;

public class Tiger extends Animal {

	// constructor must follow the rules
	public Tiger(String species) {
		super(species);
	}

	public static void main(String args[]) {
		
		// Inheritance only
		Animal animal = new Tiger("tiger");
		
		// inherited all methods without polymorphism 
		animal.printSpecies();
		animal.printAbility();
	}
}
