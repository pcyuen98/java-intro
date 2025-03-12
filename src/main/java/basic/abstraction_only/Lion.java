package basic.abstraction_only;

public class Lion extends AnimalAbstract {
	// constructor must follow the rules
	
	// Quiz: Try change the constructor name and explain why error?
	public Lion(String species) {
		super(species);
	}

	// Quiz: Why error when change the method name below 
	@Override
	public void printSpecies() {
		System.out.println("Species type is " + AnimalAbstract.TYPE);
		System.out.println("this species name is " + this.getSpecies());
	}
	
	public static void main(String args[]) {
		
		AnimalAbstract animal = new Lion("lion");
		animal.printSpecies();
		
		// Quiz: Explain why ability is null?
		animal.printAbility();
	}
}
