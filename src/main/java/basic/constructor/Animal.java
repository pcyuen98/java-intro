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
	
	public static void main (String args[]) {
		Animal animal = new Animal();
		
		System.out.println("animal-->" + animal.species);
	}
}
