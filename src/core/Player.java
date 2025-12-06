package core;

import java.util.List;

public class Player extends Person {

    private int phoneBattery;
    private double moneyAmount;
    private List<Item> inventory;

    Player(int difficulty){

    }

    public void inventoryAdd(Item item){this.inventory.add(item);}
    public void inventoryRemove(Item item){this.inventory.remove(item);}

    public double getMoneyAmount(){return(this.moneyAmount);}
    public void addMoney(double increase){this.moneyAmount = this.moneyAmount + increase;}

    public int getPhoneBattery(){return(this.phoneBattery);}
    public void chargePhone(int mins){
        this.phoneBattery = this.phoneBattery + (int)(mins * (100/60));
        if(this.phoneBattery > 100){this.phoneBattery = 100;}
        System.out.println("You spent " + mins + " charging your phone and got it up to " + this.phoneBattery + "% charged.");
    }

    void displayStatus(){

    }

    void displayInventory(){

    }

}
