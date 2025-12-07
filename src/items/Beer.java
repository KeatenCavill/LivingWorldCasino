package items;

import core.Item;
import core.Person;

public class Beer extends Item implements Consumable {
    public Beer() {
        this.name = "Beer";
        this.description = "A cold bottle of beer. Perfect for unwinding after a long day.";
        this.monetaryValue = 5.0;
    }

    @Override
    public void consume(Person person) {
        person.changeDrunk(10);
        person.changePee(5);
        person.changeGrub(-2);
        person.changeAggression(3);
        person.changeDrunk(10);
        person.changeAwareness(-5);
        person.changeHappiness(5);
        System.out.println(person.name + " drinks the beer. Drunk level increased!");
    }
}
