package core;

import java.util.List;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Path;
import npcs.Bouncer;
import envs.FrontSidewalk;

public class NPC extends Person {

    protected List<Item> inventory;
    protected List<String> phrases;
    protected double anger;

    public NPC(){

        super(getRandomName(), getRandomAge());

        try {
            this.phrases = Files.readAllLines(Path.of("messages/bar_npc_dialogues.txt"));
            if(super.peeMeter > 0.8){
                List<String> newlines = (Files.readAllLines(Path.of("messages/pee_messages.txt")));
                for(int i = 0; i < newlines.size(); i++){this.phrases.add(newlines.get(i));}
            }
            if(super.drunkMeter > 0.8){
                List<String> newlines = (Files.readAllLines(Path.of("messages/drunk_messages.txt")));
                for(int i = 0; i < newlines.size(); i++){this.phrases.add(newlines.get(i));}
            }
        } catch(Exception err) {err.printStackTrace();}

        super.drunkMeter = Math.random();
        super.grubMeter = Math.random();
        super.peeMeter = Math.random();
        this.anger = Math.random();
    }

    public List<Item> getInventory(){return(this.inventory);}
    
    public void steal(int itemnum, Player player){
        if(super.getStealDifficulty() < Math.random()){
            player.inventoryAdd(this.inventory.get(itemnum));
            this.inventory.remove(itemnum);
        } else {
            System.out.println(super.name + ": \"Hey! What are you doing?\"");
            System.out.println("You quickly flee.");
            this.anger = clamp(this.anger + 0.1, 0, 1);
        }
    }

    public void give(Player player){
        int itemnum = (int)(Math.random() * this.inventory.size());
        Item item = this.inventory.get(itemnum);
        System.out.println("Here, take this " + item.getName() + ". You might need it.");
        player.inventoryAdd(item);
        inventory.remove(itemnum);
    }

    public void talkTo(){
        int messagenum = (int)(Math.random() * this.phrases.size());
        System.out.println(this.phrases.get(messagenum));
    }

    public void fight(Player player, Bouncer bouncer, FrontSidewalk frontSidewalk){
        if(super.peeMeter >= 0.75){
            System.out.println(super.name + ": \"I don't want to fight! I'm gonna pee myself!\"");
            System.out.println(super.name + " has run away in the direction of the bathroom.");
            super.relieveOneSelf();
        } else if(super.drunkMeter >= 0.5){
            System.out.println(super.name + " swings at you but misses and faceplants on the ground. Their friend calls them an Uber home.");
        } else if(this.anger >= super.getFightLikelihood()){
            System.out.println("You and " + super.name + " get into a big fight!");
            double noticed = Math.random();
            double win = Math.random();
            double reward = (double) (Math.random() * player.getMoneyAmount());
            if(win >= 0.3){
                System.out.println("You beat " + this.name + " in a fight!");
                System.out.println("They gave you $" + reward + " to leave them alone.");
                player.addMoney(reward);
            } else {
                System.out.println(this.name + " beat you in a fight! :(");
                System.out.println("They stole $" + reward + " out of your wallet.");
                player.addMoney(-1 * reward);
            }
            if(noticed > 0.9){bouncer.kickOut(player, frontSidewalk);}
        } else {
            System.out.println(super.name + " gives you a weird look.");
            System.out.println(super.name + ": \"I'm not gonna fight you. Weirdo.\"");
            System.out.println("They leave the room.");
            int locNum = (int)(Math.random() * getLocation().getConnectedAreas().size());
            Environment newLoc = getLocation().getConnectedAreas().get(locNum);
            super.move(newLoc);
        }
    }

    private static String getRandomName(){
    String name = "temp";
        try {
            List<String> lines = Files.readAllLines(Path.of("names.txt"));
            name = lines.get(new Random().nextInt(lines.size()));
        } 
        catch(Exception err) {err.printStackTrace();}
        return name;}

    private static int getRandomAge(){
        int age = (int)(Math.random() * 29) + 21;
        return(age);
    }

}
