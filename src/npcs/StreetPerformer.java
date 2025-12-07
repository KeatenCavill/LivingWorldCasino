package npcs;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import core.NPC;
import core.Player;


public class StreetPerformer extends NPC {
    private String act;
    private double skill;
    private double earnings;

    public StreetPerformer(){
        try {
            List<String> lines = Files.readAllLines(Path.of("singer_songs/acts.txt"));
            this.act = lines.get(new Random().nextInt(lines.size()));
        }
        catch(Exception err) {err.printStackTrace();}

        this.skill = Math.random();

    }

    public String getAct(){System.out.println(super.name + "is showing off their " + this.act); return(this.act);}

    public double getSkill(){
        if(this.skill < 0.25){
            System.out.println("Well, " + super.name + " is definitely doing something...");
        } else if(this.skill > 0.8){
            System.out.println(super.name + " is so skilled, it brings a tear to your eye.");
        } else {
            System.out.println(super.name + " is doing pretty well!");
        }
        return(this.skill);
    }

    public void tip(double tip){
        this.earnings = this.earnings + tip;
        this.skill = this.skill + (tip / 100);
        if(this.skill > 1){
            this.skill = 1;
        }
    }

    public void steal(Player player){
        double theftAmount = Math.random() * this.earnings;
        if(theftAmount == 0){
            System.out.println(super.name + " didn't have any money for you to steal!");
        } else {
            System.out.println("You shove your hand into " + super.name + "'s tip jar when they aren't looking and make out with $" + theftAmount + ".");
            System.out.println("Shame on you!");
        }
    }
}
