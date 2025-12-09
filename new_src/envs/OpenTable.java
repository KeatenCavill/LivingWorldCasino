package envs;

import core.*;
import items.HalfEatenBurger;

public class OpenTable extends Environment {

    public OpenTable() {
        super("Open Table", "A small table with a few chairs. Looks like someone left something behind.");
        // Seed with a half-eaten burger that players can pick up
        addItem(new HalfEatenBurger());
    }
    
    @Override
    public void enter(Person person) {
        if (person == null) return;

        // Limit capacity (NPCs + player) to 5
        if (getPeople().size() >= 5) {
            System.out.println("The table is full. No seats available right now.");
            return;
        }

        super.enter(person);
    }
    
}
