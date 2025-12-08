package envs;

import core.Environment;
import core.Person;
import items.WeirdPill;
import core.Player;
import npcs.AlleyMan;

public class Alley extends Environment {
    public Alley(){
        super("Alley", "You find yourself in a dimly lit alleyway, with trash cans lining the walls and a faint smell of dampness in the air. There appears to be a man sitting against the wall.");
    
        AlleyMan alleyMan = new AlleyMan();
        addPerson(alleyMan);
    }

    @Override
    public void enter(Person person){
        super.enter(person);
        System.out.println("The alley is quiet except for the occasional drip of water from a leaky pipe. A shady figure sits in the corner, eyeing you warily.");
    }

    public void giveWeirdPill(Player player){
        player.inventoryAdd(new WeirdPill());
        System.out.println("The Alley man gives you a weird pill and disappears into the shadows.");
    }
}
