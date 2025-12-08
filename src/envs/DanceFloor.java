package envs;

import core.Environment;
import core.Person;
import core.Player;
import npcs.Singer;

public class DanceFloor extends Environment {

    private int turnsOnFloor = 0;

    public DanceFloor() {
        super("Dance Floor", "You step onto the pulsing dance floor."); // Call the superclass constructor with appropriate arguments
        
        Singer singer = new Singer();
        addPerson(singer);
    }

    @Override
    public void enter(Person person) {
        super.enter(person);
        turnsOnFloor = 0;
    }

    @Override
    public void stay(Person person) {
        turnsOnFloor++;

        if (turnsOnFloor <= 5) {
            // early: fun
            person.changeHappieness(4);
            person.changeGrub(1);
            System.out.println("You dance and feel great!");
        } else if (turnsOnFloor <= 10) {
            // still fun but tiring
            person.changeHappieness(1);
            person.changeGrub(2);
            System.out.println("You're getting a bit sweaty from all the dancing.");
        } else {
            // too long: tired
            person.changeHappieness(-5);
            person.changeGrub(3);
            System.out.println("You're exhausted from dancing so long.");
        }
    }

    @Override
    public void leave(Person person) {
        turnsOnFloor = 0;
    }

    public void listenToSinger(Player player){
        Object singer = null;
        if (singer == null){
            System.out.println("There's no singer here right now.");
            return;
        }
    }
}
