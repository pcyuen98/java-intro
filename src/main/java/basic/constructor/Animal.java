package basic.constructor;

public class Animal {

	private String species;
	
	Animal() {
		this.species = "Default animal";
	}
	
	Animal(String species) {
		this.species = species;
	}
	
	void printSpecies() {
		System.out.println("this species is " + this.species);
	}
	
	
	public void setSpecies(String species) {
		this.species = species;
	}

	public static void main (String args[]) {
		Animal animal = new Animal();
		// Animal animal = new Animal("Lion");
		
		// animal.species = "lion";
		animal.setSpecies("lion");
		System.out.println("animal-->" + animal.species);
	}
}
