package envs;

import core.*;
import npcs.*;

public class FrontSidewalk extends Environment {

    public FrontSidewalk() {
        super("Front Sidewalk", "You step out onto the sidewalk in front of the casino.");

        Bouncer bouncer = new Bouncer();
        StreetPerformer streetPerformer = new StreetPerformer();

        addPeople(bouncer, streetPerformer);
    }

    public void watchStreetPerformer(Player player){
        StreetPerformer found = null;
        for (Person p : getPeople()){
            if (p instanceof StreetPerformer){
                found = (StreetPerformer) p;
                break;
            }
        }

        if (found == null){
            System.out.println("There's no street performer here right now.");
            return;
        }

        // Call the performer's method that announces/prints their act
        found.getAct();
    }

}
