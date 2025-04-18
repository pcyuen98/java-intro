package basic.inheritance;

public class LionPolymorphism extends Animal {
	// constructor must follow the rules
	public LionPolymorphism(String species) {
		super(species);
	}

	// Object-Oriented Design Principles - Open-Closed Principle
	//i.e. open for extension (new functionality), closed for modification (of existing code)
	
	//By following the Open-Closed Principle, you create more flexible, maintainable, and robust Java applications.
	//Means you are flexible enough to open(create or morth the method) or close (re-used)
	
	// polymorphism 1
	@Override
	protected void printAbility() {
		System.out.println(this.species + " ADDITIONAL ability is " + this.ability);
	}
	
	public static void main(String args[]) {
		
		// Parent is card
		Animal animal = new LionPolymorphism("lion");
		
		// Quiz: What is the difference between animal2 and animal initialization?
		// When to use?	
		LionPolymorphism animal2 = new LionPolymorphism("lion");
		
		animal.setAbility("swimming");
		
		// inherite printSpecies and morth the ability
		
		// Object-Oriented Design Principles - DRY (Do not Repeat Yourself) – avoid code duplications
		// printAbility can be "re-used" in sub class
		animal.printSpecies();
		animal.printAbility();
	}
}
