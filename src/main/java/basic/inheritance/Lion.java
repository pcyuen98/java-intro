package basic.inheritance;

public class Lion extends Animal {
	// constructor must follow the rules
	public Lion(String species) {
		super(species);
	}

	// Object-Oriented Design Principles - Open-Closed Principle
	//i.e. open for extension (new functionality), closed for modification (of existing code)
	
	//By following the Open-Closed Principle, you create more flexible, maintainable, and robust Java applications.
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
		
		// Object-Oriented Design Principles - DRY (Do not Repeat Yourself) – avoid code duplications
		// printAbility can be "re-used" in sub class
		animal.printSpecies();
		animal.printAbility();
	}
}
