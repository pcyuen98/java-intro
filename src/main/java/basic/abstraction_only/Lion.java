package basic.abstraction_only;

public class Lion implements AnimalAbstract {
	// constructor must follow the rules
	
	private String species;
	
	public Lion(String species) {
		// Quiz: Why error below?
		// super(species);
		this.species = species;
	}

	// Quiz: Why error when change the method name below 
	@Override
	public void printSpecies() {
		System.out.println("Species type is " + AnimalAbstract.TYPE);
		System.out.println("this species name is " + this.species);
	}
	
	public static void main(String args[]) {
		
		AnimalAbstract animal = new Lion("lion");
		animal.printSpecies();
	}

}
