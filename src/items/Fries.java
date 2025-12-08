package items;

import core.Item;
import core.Person;
    
public class Fries extends Item implements Consumable{
    public Fries(){
        super("Fries", "A serving of crispy golden french fries.", 3.0);
    }

    @Override
    public void consume(Person person){
        person.changeGrub(-15);
        person.changeHappieness(20);
        person.changeAwareness(5);
        person.changeAggression(-5);
        System.out.println(person.name + " eats the fries. Hunger decreased!");
    }
}