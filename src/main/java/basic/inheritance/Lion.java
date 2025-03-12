package basic.inheritance;

public class Lion extends Animal {
	// constructor must follow the rules
	public Lion(String species) {
		super(species);
	}

	// printAbility can be "re-used" in sub class
	@Override
	protected void printAbility() {
		System.out.println(this.species + " ADDITIONAL ability is " + this.ability);
	}
	
	public static void main(String args[]) {
		
		// Parent is card
		Animal animal = new Lion("lion");
		
		// polymorphism
		animal.setAbility("swimming");
		
		// inherite printSpecies and morth the ability
		animal.printSpecies();
		animal.printAbility();
	}
}
