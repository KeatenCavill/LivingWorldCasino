package envs;

import core.Environment;
import npcs.Bouncer;
import npcs.StreetPerformer;

public class FrontSidewalk extends Environment {

    public FrontSidewalk() {
        super("Front Sidewalk", "You step out onto the sidewalk in front of the casino.");

        Bouncer bouncer = new Bouncer();
        StreetPerformer streetPerformer = new StreetPerformer();

        addPeople(bouncer, streetPerformer);
    }

}
