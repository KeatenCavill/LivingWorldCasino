package npcs;
import core.NPC;
import core.Player;
import envs.FrontSidewalk;


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

    public void kickOut(Player player, FrontSidewalk frontSidewalk){
        if(!bribed){
            this.kicked = true;
            System.out.println(super.name + " grabs you by the back of the shirt and hauls you outside!");
            System.out.println(super.name + ": \"And stay out!\"");
            player.move(frontSidewalk);
        } else {
            System.out.println(super.name + ": \"I'll let you off this time, but this is your last warning!\"");
            this.bribed = false;
        }
    }

    public void bribe(double bribeAmount, Player player){
        if(super.anger > 0.6 && bribeAmount < 50){
            player.addMoney(-1 * bribeAmount);
            System.out.println(super.name + ": \"What, you think I can be bought with $" + bribeAmount + "?? You're BANNED!");
            System.out.println(super.name + " shoves you away from the building by your shoulder!");
            System.out.println(super.name + " took your money, anyway.");
        } else{
            this.kicked = false;
            player.addMoney(-1 * bribeAmount);
            System.out.println(super.name + ": \"You're good. Don't mention this, ya hear?\"");
        }
    }

}
