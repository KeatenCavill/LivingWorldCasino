package npcs;

import core.NPC;

/**
 * Very simple alley NPC for the basic game loop.
 * No vendor logic here; the Alley environment itself can give the player
 * a WeirdPill when appropriate.
 */
public class AlleyMan extends NPC {

    public AlleyMan(){
        super();
    }

    @Override
    public void talkTo(){
        System.out.println(super.name + ": \"Psst... you look like you might be interested in something strange.\"");
    }
}
