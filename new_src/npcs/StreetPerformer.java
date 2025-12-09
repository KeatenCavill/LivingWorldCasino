package npcs;
import core.NPC;
import core.Player;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;


public class StreetPerformer extends NPC {
    private String act;
    private double skill;
    private double earnings;

    public StreetPerformer(){
        try {
            List<String> lines = Files.readAllLines(
                Path.of("src", "npcs", "performance_acts", "streetperformance_acts.txt")
            );
            if (!lines.isEmpty()){
                this.act = lines.get(new Random().nextInt(lines.size()));
            } else {
                this.act = "mysterious street performance";
            }
        }
        catch(Exception err) {
            this.act = "mysterious street performance";
        }

        this.skill = Math.random();
    }

    public String getAct(){
        System.out.println(super.name + " is showing off their " + this.act);
        return this.act;
    }

    public double getSkill(){
        if(this.skill < 0.25){
            System.out.println("Well, " + super.name + " is definitely doing something...");
        } else if(this.skill > 0.8){
            System.out.println(super.name + " is so skilled, it brings a tear to your eye.");
        } else {
            System.out.println(super.name + " is doing pretty well!");
        }
        return this.skill;
    }

    public void tip(double tip){
        this.earnings += tip;
        this.skill = super.clamp(this.skill + (tip / 100), 0, 1);
        System.out.println(super.name + " grins at you. Their act seems more enthusiastic now!");
    }

    public void steal(Player player){
        double theftAmount = Math.random() * this.earnings;
        if(theftAmount == 0){
            System.out.println(super.name + " didn't have any money for you to steal!");
        } else if(super.getStealDifficulty() < Math.random()){
            System.out.println("You shove your hand into " + super.name + "'s tip jar when they aren't looking and make out with $" + theftAmount + ".");
            System.out.println("Shame on you!");
        } else {
            System.out.println(super.name + " never looked away long enough for you to snatch anything. They were staring right. At. You.");
        }
    }
}
