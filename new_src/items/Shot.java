package items;

import core.*;

public class Shot extends Item implements Consumable {
    public Shot() {
        super("Shot", "A small but powerful shot. Quick and effective.", 4.0);
    }

    @Override
    public void consume(Person person) {
        if (person == null) return;
        person.changeDrunk(30);
        person.changePee(3);
        person.changeAggression(4);
        person.changeAwareness(-12);
        person.changeHappieness(1);
        System.out.println(person.getName() + " takes a shot. They feel dizzy.");
    }
}