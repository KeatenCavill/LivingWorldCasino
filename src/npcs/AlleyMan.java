package npcs;
import core.Item;
import core.NPC;


public class AlleyMan extends NPC implements Vendor {

    private Item[] forSale = new Item[5];
    private Item[] GoodsOp = new Item[] {};

    private void populateGoods(){
        for(int i = 0; i < 4; i++){
            int saleNum = (int) (Math.random() * this.GoodsOp.length);
            Item saleItem = this.GoodsOp[saleNum];
            this.forSale[i] = saleItem;
        }
    }

    public AlleyMan(){
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
    public void buyItem(Item item){

    }
}