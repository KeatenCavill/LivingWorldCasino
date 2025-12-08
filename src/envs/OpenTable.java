package envs;

import core.Environment;
import core.Person;
import items.HalfEatenBurger;

public class OpenTable extends Environment {

    public OpenTable() {
        super("Open Table", "A small table with a few chairs. Looks like someone left something behind.");
        // Seed with a half-eaten burger that players can pick up
        addItem(new HalfEatenBurger());
    }
    
}
