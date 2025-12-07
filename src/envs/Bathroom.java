package envs;

import core.Environment;
import core.Person;
import core.Player;

public class Bathroom extends Environment {

    public Bathroom() {
        this.name = "Bathroom";
        this.entranceMessage = "You push open the bathroom door. It smells… like a bathroom (use your imagination).";
    }

    @Override
    public void onEnter(Person person) {
        super.onEnter(person);
        System.out.println("Stalls line the back wall and a flickering light buzzes overhead.");
    }

    public void useBathroom(Player player) {
        double need = player.getPeeMeter();

        if (need <= 5) {
            System.out.println("You don’t really have to go, but you wash your hands anyway.");
            // small positive mood bump for being clean, good job for washing your hands in a place like this
            player.changeHappiness(2);
        } else {
            System.out.println("You find a stall and finally relieve yourself.");
            player.relieveOneSelf(); 
            player.changeHappiness(5); 
        }
    }
}
