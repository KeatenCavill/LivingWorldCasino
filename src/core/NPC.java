package core;
import core.Item;

import java.util.List;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Path;

// options: fight, steal from, give

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
        this.anger = Math.random();
    }
    
    public void steal(int itemnum, Player player){
        player.inventoryAdd(this.inventory.get(itemnum));
        inventory.remove(itemnum);
    }

    public void give(Player player){
        int itemnum = (int)(Math.random() * this.inventory.size());
        Item item = this.inventory.get(itemnum);
        //System.out.println("Here, take this " + item.getName() + ". You might need it.");
        player.inventoryAdd(item);
        inventory.remove(itemnum);
    }

    public void talkTo(){
        int messagenum = (int)(Math.random() * this.phrases.size());
        System.out.println(this.phrases.get(messagenum));
    }

    public void fight(){}

}
