package items;

import core.Item;
import core.Person;

public class Wine extends Item implements Consumable {
    public Wine() {
        super("Wine", "A glass of red wine. Smooth and calming.", 8.0);
    }

    @Override
    public void consume(Person person) {
        if (person == null) return;
        person.changeDrunk(20);
        person.changePee(6);
        person.changeAwareness(-6);
        person.changeHappieness(6);
        System.out.println(person.name + " sips the wine. A pleasant warmth spreads through them.");
    }
}
