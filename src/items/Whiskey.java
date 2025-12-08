package items;

import core.*;


public class Whiskey extends Item implements Consumable {
    public Whiskey() {
        super("Whiskey", "A strong shot of whiskey. Not for the faint-hearted.", 7.0);
    }

    @Override
    public void consume(Person person) {
        if (person == null) return;
        person.changeDrunk(25);
        person.changePee(4);
        person.changeAggression(5);
        person.changeAwareness(-10);
        person.changeHappieness(2);
        System.out.println(person.name + " downs the whiskey. It hits hard.");
    }
}
