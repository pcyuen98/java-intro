package basic.abstraction_only;

// abstract class
public abstract class AnimalAbstract {

	// for inheritance learning purposes
	public static final String TYPE = "CARNIVOR";
	private String species;
	private String ability;

	public AnimalAbstract(String species) {
		this.species = species;
	}

	// define rule no.1 - Child class must implement the below
	public abstract void printSpecies();
	
	public void printAbility() {
		System.out.println(this.species + " ability is " + this.ability);
	}
	
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public static void main(String[] args) {
		
		// Quiz: Why error below?
		//AnimalAbstract animal = new AnimalAbstract();

	}
	
}