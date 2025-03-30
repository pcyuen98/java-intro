package basic.inheritance;

// parent class
public class Animal {

	// for inheritance learning purposes
	public static final String TYPE = "CARNIVOR";
	
	protected String species;
	protected String ability = "sleeping";
	
	// method name == class name is constructor
	// Animal rule - subclass must have a same constructor
	// 
	public Animal(String species) {
		this.species = species;
	}

	// printjob can be used in sub class
	// method to be reused in Father and Uncle
	protected void printSpecies() {
		System.out.println("Animal Type is = " + Animal.TYPE);
		System.out.println("New Species is = " + this.species);
	}

	// printAbility can be "re-used" in sub class
	protected void printAbility() {
		System.out.println(this.species + " ability is " + this.ability);
	}
	
	// encapsulation / protection / public / private / protected
	public void setAbility(String ability) {
		this.ability = ability;
	}
	
	public static void main(String[] args) {

		Animal animal = new Animal("Elepant");
		animal.printSpecies();
		animal.setAbility("sleeping");
		animal.printAbility();

	}
	
}