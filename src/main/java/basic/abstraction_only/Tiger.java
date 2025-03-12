package basic.abstraction_only;

public class Tiger extends AnimalAbstract {

	// constructor must follow the rules
	public Tiger(String species) {
		super(species);
	}

	@Override
	public void printSpecies() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]) {
		
		// follow the example of Lion.java expected output as below
		// Do not change the parent class else violation of OOP. Quiz: Why violate?
		
		//Species type is CARNIVOR
		//this species name is tiger
		//tiger NEW ability is jump high
	}

}
