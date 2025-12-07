package items;

import core.Item;
import core.Person;
    
public class Fries extends Item implements Consumable{
    public Fries(){
        this.name = "Fries";
        this.description = "A serving of crispy golden french fries.";
        this.monetaryValue = 3.0;
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