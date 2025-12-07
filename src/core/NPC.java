package core;

import java.util.List;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Path;

public class NPC extends Person {

    private List<Item> inventory;
    private List<String> phrases;
    private double anger;

    public NPC(){
        try {
            List<String> lines = Files.readAllLines(Path.of("names.txt"));
            super.name = lines.get(new Random().nextInt(lines.size()));
            this.phrases = Files.readAllLines(Path.of("bar_npc_dialogues.txt"));
        } 
        catch(Exception err) {err.printStackTrace();}

        super.drunkMeter = Math.random();
        super.grubMeter = Math.random();
        super.peeMeter = Math.random();
        super.age = (int)(Math.random() * 29) + 21;
        this.anger = Math.random();
    }
    
    public void steal(int itemnum, Player player){
        player.inventoryAdd(this.inventory.get(itemnum));
        inventory.remove(itemnum);
    }

    public void give(Player player){
        int itemnum = (int)(Math.random() * this.inventory.size());
        Item item = this.inventory.get(itemnum);
        // System.out.println("Here, take this " + item.getName() + ". You might need it.");
        player.inventoryAdd(item);
        inventory.remove(itemnum);
    }

    public void talkTo(){
        int messagenum = (int)(Math.random() * this.phrases.size());
        System.out.println(this.phrases.get(messagenum));
    }

    public void fight(Player player){
        if(super.peeMeter >= 0.75){
            System.out.println(super.name + ": \"I don't want to fight! I'm gonna pee myself!\"");
            System.out.println(super.name + " has run away in the direction of the bathroom.");
        } else if(super.drunkMeter >= 0.5){
            System.out.println(super.name + " swings at you but misses and faceplants on the ground. Their friend calls them an Uber home.");
        } else if(this.anger >= -.5){
            System.out.println("You and " + super.name + " get into a big fight!");
            double noticed = Math.random();
            double win = Math.random();
            double reward = (double) (Math.random() * player.getMoneyAmount());
            if(noticed > 0.9){} // get kicked out?
            if(win >= 0.3){
                System.out.println("You beat " + this.name + " in a fight!");
                System.out.println("They gave you $" + reward + " to leave them alone.");
                player.addMoney(reward);
            } else {
                System.out.println(this.name + " beat you in a fight! :(");
                System.out.println("They stole $" + reward + " out of your wallet.");
                player.addMoney(-1 * reward);
            }
        }
    }

}
