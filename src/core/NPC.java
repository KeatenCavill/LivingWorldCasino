package core;
import core.Item;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

// give: inventory, drunk level
// options: fight, steal from, give, talk to

public class NPC extends Person {

    private String name;
    private Item[] inventory;
    private double drunkness;
    private double anger;

    public NPC(){

        try {
            List<String> lines = Files.readAllLines(Path.of("names.txt"));
            this.name = lines.get(new Random().nextInt(lines.size()));
        } 
        catch(Exception err) {err.printStackTrace();}
        // choose random meter levels
        
    }
    
    public void give(Item item){

    }

    public void talkTo(){

    }

}
