package npcs;
import java.util.List;

import core.Item;
import core.NPC;
import core.Player;
import items.*;



public class Cook extends NPC implements Vendor {

    private List<Item> forSale;
    
    private void populateGoods(){
        Burger burger = new Burger(); this.forSale.add(burger);
        Fries fries = new Fries(); this.forSale.add(fries);
    };

    public Cook(){
        populateGoods();
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
