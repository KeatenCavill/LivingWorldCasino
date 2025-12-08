package npcs;
import java.util.List;
import core.Item;
import core.NPC;
import core.Player;
import items.*;

public class Bartender extends NPC implements Vendor {

    private List<Item> forSale;
    
    private void populateGoods(){
        Beer beer = new Beer(); this.forSale.add(beer);
        Soda soda = new Soda(); this.forSale.add(soda);
    };

    public Bartender(){
        populateGoods();
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
