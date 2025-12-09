package items;

import core.*;

public class Burger extends Item implements Consumable{
    public Burger(){
        super("Burger", "A juicy beef burger with lettuce, tomato, and cheese.", 15.0);
    }

    @Override
    public void consume(Person person){
        if (person == null) return;
        person.changeGrub(-20);
        System.out.println(person.getName() + " eats the burger. Hunger decreased!");

    }
}
