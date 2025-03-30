package basic.inheritance.FavorCompositionOverInheritance;

public class Animal {
    Ability ability;

    Animal(Ability ability) {
        this.ability = ability;
    }
    
    void printAbility() {
    	ability.printAbility();
    }
}
