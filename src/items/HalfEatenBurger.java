package items;

import core.Item;
import core.Person;

public class HalfEatenBurger extends Item implements Consumable {
    public HalfEatenBurger() {
        super("Half-Eaten Burger", "A half-eaten burger left on a table. It's a bit gross but filling.", 0.5);
    }

    @Override
    public void consume(Person person) {
        if (person == null) return;
        person.changeGrub(-20);
        person.changeThirst(5);
        person.changeHappieness(-2);
        System.out.println(person.name + " eats the half-eaten burger. It fills them up a bit.");
    }
}
