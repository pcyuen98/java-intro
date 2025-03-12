package basic.classObj;

// Objective exercise: Fix the bug and learn basic object and class

public class BirdClass {

	private String species;

	//AnimalClass(String species) {
	//	this.species = species;
	//}

	// it has a function to print the species, input must be specified first
	
	private void printSpecies() {
		System.out.println("Species is = " + this.species);
	}


	public static void main(String[] args) {

		// fix the bug below
		// BirdClass bird = new BirdClass("Bird Object");
		// bird.printSpecies();
	}
	
	
}
