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

    void displayStatus(){

    }

    void displayInventory(){

    }

}
