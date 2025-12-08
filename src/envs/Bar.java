package envs;

import core.*;
import items.*;
import npcs.Bartender;


public class Bar extends Environment {
    public Bar() {
        super("Bar", "You step into the lively bar filled with the hum of conversation and clinking glasses. The scent of ale and spirits fills the air, and a bartender stands ready to serve.");

        Bartender bartender = new Bartender();
        addPerson(bartender);
    }

    @Override
    public void enter(Person person) {
        super.enter(person);
    }

    private boolean tryCharge(Player player, double price){
        if (player.getMoneyAmount() >= price){
            player.addMoney(-price);
            return true;
        } else{
            System.out.println("You don't have enough money to buy this item.");
            return false;
        }
    }

    public void buyBeer(Player player){
        double price = 5.0;
        if (tryCharge(player, price)){
            player.inventoryAdd(new Beer());
            System.out.println("You bought a Beer for $" + price);
        }
    }

    public void buyWine(Player player){
        double price = 8.0;
        if (tryCharge(player, price)){
            player.inventoryAdd(new Wine());
            System.out.println("You bought a Wine for $" + price);
        }
    }

    public void buyWhiskey(Player player){
        double price = 7.0;
        if (tryCharge(player, price)){
            player.inventoryAdd(new Whiskey());
            System.out.println("You bought a Whiskey for $" + price);
        }
    }

    public void buyShot(Player player){
        double price = 4.0;
        if (tryCharge(player, price)){
            player.inventoryAdd(new Shot());
            System.out.println("You bought a Shot for $" + price);
        }
    }
}
