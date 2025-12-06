package npcs;
import java.util.List;
import core.Item;
import core.NPC;
import core.Player;
import items.*;

public class Bartender extends NPC implements Vendor {

    private List<Item> forSale;
    private List<Item> GoodsOp;
    
    private void makeGoodsOptions(){};

    private void populateGoods(int numGoods){
        for(int i = 0; i < numGoods; i++){
            int saleNum = (int) (Math.random() * this.GoodsOp.size());
            Item saleItem = this.GoodsOp.get(saleNum);
            this.forSale.add(saleItem);
        }
    }

    public Bartender(){
        makeGoodsOptions();
        populateGoods(5);
    }
    
    public void displayGoods(){
        System.out.println(super.name + ": \"Hey, what can I get you?\"");
        /*
        int inc = 1;
        for(Item item : this.forSale){
            String message = inc + ") " + item.getName() + " : $" + item.getMonetaryValue();
            System.out.println(message);
            inc ++;
        }
        */
    }
    public void buyItem(int item, Player player){
        int itemnum = item - 1;
        Item purchase = forSale.get(itemnum);
        player.inventoryAdd(purchase);
        this.forSale.remove(itemnum);
        populateGoods(1);
        System.out.println(super.name + ": \"Here ya go!\"");

    }

}
