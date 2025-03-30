package basic.inheritance.FavorCompositionOverInheritance;

//Favour Composition over Inheritance

/*The principle of "Favor Composition over Inheritance" 
* advocates for designing object-oriented systems by composing objects 
* from smaller, reusable components rather than 
* relying heavily on inheritance hierarchies. 
* This approach promotes flexibility, maintainability, 
* and reduces the risk of tightly coupled code.
*/

//and Inversion Principle or 
/*The Hollywood Principle, "Don't call us, we'll call you," 
* is a design principle that promotes loose coupling and inversion of control (IoC). 
* In Java, this principle is often implemented using techniques like:
*/
//In Spring Boot, this is so call dependency injection or a service implementation

//based on the Animal java class
//1. Create an Ability interface 
//2. Create 2 subclasses with StrengthAbility and TeamWorkAbility both that implements Ability
//3. Create Tiger class extends Animal Class with composition of StrengthAbility (Sample Provided)
//4. Create Lion class extends Animal Class with composition of TeamWorkAbility

// Note: Create/Complete TeamWorkAbility and Lion class based on example below

public class Tiger extends Animal{

	Tiger(Ability ability) {
		super(ability);
	}

	public static void main(String[] args) {
		Animal tiger = new Animal(new StrengthAbility());
		tiger.printAbility();
	}
	
}
