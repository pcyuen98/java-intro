package basic.classObj;

// in programming, class is a blank template or document that need input
public class AnimalClass {
	
	private String species;

	AnimalClass(String species) {
		this.species = species;
	}

	// it has a function to print the species, input must be specified first
	private void printSpecies() {
		System.out.println("Species is = " + this.species);
	}


	public static void main(String[] args) {

		// fill in the inputs
		AnimalClass lionObj = new AnimalClass("Lion Object");
		lionObj.printSpecies();
	}
	
}