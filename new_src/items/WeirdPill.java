package items;

import core.*;

public class WeirdPill extends Item implements Consumable {

    public WeirdPill() {
        super("Weird Pill", "A sketchy pill you got in the alley. Probably a bad idea.", 0.0);
    }

    @Override
    public void consume(Person person) {
        if (person == null) return;
        person.changeDrunk(30);
        person.changeGrub(-5);
        person.changePee(5);

        person.changeHappieness(50);
        person.changeAggression(1);
        person.changeAwareness(-40); //this person... is gunna be fucked up for a bit
        System.out.println(person.getName() + " takes the weird pill. Reality feels strange...");
    }
}
