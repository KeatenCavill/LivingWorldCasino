package npcs;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

import core.Item;
import core.NPC;
import core.Player;
import items.*;



public class Cook extends NPC implements Vendor {

    private List<Item> forSale;
    private List<String> greetings;
    
    private void populateGoods(){
        Burger burger = new Burger(); this.forSale.add(burger);
        Fries fries = new Fries(); this.forSale.add(fries);
    };

    public Cook(){
        this.forSale = new ArrayList<>();
        this.greetings = new ArrayList<>();
        populateGoods();
        try {
            this.greetings = Files.readAllLines(
                Path.of("src", "core", "messages", "vendor_greetings.txt")
            );
        } catch(Exception err) {
            // Fallback: leave greetings as-is
        }
    }

    public void talkTo(){
        int greetingNum = (int)(Math.random() * this.greetings.size());
        System.out.println(this.greetings.get(greetingNum));
    }
    
    public void displayGoods(){
        System.out.println(super.name + ": \"What do you want to eat tonight?\"");
        int inc = 1;
        for(Item item : this.forSale){
            String message = inc + ") " + item.getName() + " : $" + item.getMonetaryValue();
            System.out.println(message);
            inc ++;
        }
    }
    
    public void buyItem(int item, Player player){
        int itemnum = item - 1;
        Item purchase = forSale.get(itemnum);
        player.inventoryAdd(purchase);
        player.addMoney((-1) * purchase.getMonetaryValue());
        System.out.println(super.name + ": \"Order up!\"");

    }
    
}
