package npcs;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import core.Item;
import core.NPC;
import core.Player;
import items.*;


public class AlleyMan extends NPC implements Vendor {

    private List<Item> forSale;
    private List<Item> GoodsOp;
    private List<String> greetings;

    private void makeGoodsOptions(){
        HalfEatenBurger sketchyFood = new HalfEatenBurger(); this.GoodsOp.add(sketchyFood);
        WeirdPill drugs = new WeirdPill(); this.GoodsOp.add(drugs);
        Beer beer = new Beer(); this.GoodsOp.add(beer);
        Shot shot = new Shot(); this.GoodsOp.add(shot);
        Soda soda = new Soda(); this.GoodsOp.add(soda);
    };

    private void populateGoods(int numGoods){
        for(int i = 0; i < numGoods; i++){
            int saleNum = (int) (Math.random() * this.GoodsOp.size());
            Item saleItem = this.GoodsOp.get(saleNum);
            this.forSale.add(saleItem);
        }
    }

    public AlleyMan(){
        makeGoodsOptions();
        populateGoods(3);try {
            this.greetings = Files.readAllLines(Path.of("vendor_greetings.txt"));
        } catch(Exception err) {err.printStackTrace();}
    }

    public void talkTo(){
        int greetingNum = (int)(Math.random() * this.greetings.size());
        System.out.println(this.greetings.get(greetingNum));
    }
    
    public void displayGoods(){
        System.out.println(super.name + ": \"Aight, this here's what I got to gives ya. See anything you like?\"");
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
        this.forSale.remove(itemnum);
        populateGoods(1);
        System.out.println(super.name + ": \"Ah, that there " + purchase.getName() + " is top of the line. I'm giving you a steal!\"");

    }
}