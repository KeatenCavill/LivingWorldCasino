package items;

import core.*;

public class Beer extends Item implements Consumable {
    public Beer() {
        super("Beer", "A cold bottle of beer. Perfect for unwinding after a long day.", 5.0);
    }

    @Override
    public void consume(Person person) {
        if (person == null) return;
        person.changeDrunk(15);
        person.changePee(7);
        person.changeGrub(-2);
        person.changeAggression(2);
        person.changeAwareness(-5);
        person.changeHappieness(5);
        System.out.println(person.getName() + " drinks the beer. Drunk level increased!");
    }
}
