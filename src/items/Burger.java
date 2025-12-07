package items;

import core.Item;
import core.Person;

public class Burger extends Item implements Consumable{
    public Burger(){
        this.name = "Burger";
        this.description = "A juicy beef burger with lettuce, tomato, and cheese.";
        this.monetaryValue = 15.0;
    }

    @Override
    public void consume(Person person){
        person.changeGrub(-20);
        person.changeHappieness(20);
        person.changeAwareness(5);
        person.changeAggression(-5);
        System.out.println(person.name + " eats the burger. Hunger decreased!");

    }
}
