package basic.abstraction_interface;

public class Lion implements AnimalInterface {
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
		System.out.println("Species type is " + AnimalInterface.TYPE);
		System.out.println("this species name is " + this.species);
	}
	
	public static void main(String args[]) {
		
		AnimalInterface animal = new Lion("lion");
		animal.printSpecies();
	}

}
