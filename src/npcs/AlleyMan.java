package npcs;
import java.util.List;

import core.Item;
import core.NPC;
import core.Player;


public class AlleyMan extends NPC implements Vendor {

    private List<Item> forSale;
    private List<Item> GoodsOp;

    private void makeGoodsOptions(){};

    private void populateGoods(){
        for(int i = 0; i < 5; i++){
            int saleNum = (int) (Math.random() * this.GoodsOp.size());
            Item saleItem = this.GoodsOp.get(saleNum);
            this.forSale.add(saleItem);
        }
    }

    public AlleyMan(){
        makeGoodsOptions();
        populateGoods();
    }
    
    public void displayGoods(){
        int inc = 1;
        for(Item item : this.forSale){
            String message = inc + ") " + item;
            System.out.println(message);
            inc ++;
        }
    }
    public void buyItem(int item, Player player){

    }
}