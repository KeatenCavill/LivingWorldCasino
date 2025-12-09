package npcs;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;
import core.Item;
import core.NPC;
import core.Player;
import items.*;

public class Bartender extends NPC implements Vendor {

    private List<Item> forSale;
    private List<String> greetings;
    
    private void populateGoods(){
        Beer beer = new Beer(); this.forSale.add(beer);
        Soda soda = new Soda(); this.forSale.add(soda);
        Shot shot = new Shot(); this.forSale.add(shot);
        Whiskey whiskey = new Whiskey(); this.forSale.add(whiskey);
        Wine wine = new Wine(); this.forSale.add(wine);
    }

    public Bartender(){
        this.forSale = new ArrayList<>();
        this.greetings = new ArrayList<>();
        populateGoods();
        try {
            this.greetings = Files.readAllLines(
                Path.of("src", "core", "messages", "vendor_greetings.txt")
            );
        } catch(Exception err) {
            // ignore, leave greetings empty
        }
    }

    public void talkTo(){
        int greetingNum = (int)(Math.random() * this.greetings.size());
        if (this.greetings.isEmpty()){
            System.out.println(super.name + ": \"What can I get you?\"");
        } else {
            System.out.println(this.greetings.get(greetingNum));
        }
    }
    
    public void displayGoods(){
        System.out.println(super.name + ": \"Hey, what can I get you?\"");
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
        System.out.println(super.name + ": \"Here ya go!\"");
    }

}
