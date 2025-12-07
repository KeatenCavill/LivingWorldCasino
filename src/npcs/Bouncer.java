package npcs;
import core.NPC;
import core.Player;


public class Bouncer extends NPC {

    boolean kicked = false;
    boolean bribed = false;
    
    public Bouncer(){
        super.drunkMeter = 0;
    }
    
    public boolean checkID(Player player){
        if(player.age < 21){
            System.out.println(super.name + ": \"What are you doing here, kid? Get out of here!\"");
            this.kicked = true;
            return(false);
        } else{
            System.out.println(super.name + ": \"Alright, you're good to go.\"");
            return(true);
        }
    }

    public void kickOut(){
        if(!bribed){
            this.kicked = true;
            System.out.println(super.name + " grabs you by the back of the shirt and hauls you outside!");
            System.out.println(super.name + ": \"And stay out!\"");
            // NEED A WAY TO ACTUALLY MOVE THE PLAYER'S POSITION
        } else {
            System.out.println(super.name + ": \"I'll let you off this time, but this is your last warning!\"");
            this.bribed = false;
        }
    }

    public void bribe(double bribeAmount){
        if(super.anger > 0.6 && bribeAmount < 50){
            System.out.println(super.name + ": \"What, you think I can be bought with $" + bribeAmount + "?? You're BANNED!");
            System.out.println(super.name + " shoves you away from the building by your shoulder!");
        } else{
            this.kicked = false;
            System.out.println(super.name + ": \"You're good. Don't mention this, ya hear?\"");
        }
    }

}
