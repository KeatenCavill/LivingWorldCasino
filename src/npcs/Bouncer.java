package npcs;
import core.NPC;
import core.Player;


public class Bouncer extends NPC {
    
    public Bouncer(){
        super.drunkMeter = 0;
    }
    
    public boolean checkID(Player player){
        if(player.age < 21){
            System.out.println(super.name + ": \"What are you doing here, kid? Get out of here!\"");
            return(false);
        } else{
            System.out.println(super.name + ": \"Alright, you're good to go.\"");
            return(true);
        }
    }

}
