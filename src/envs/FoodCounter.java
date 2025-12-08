package envs;

import core.*;
import items.*;
import npcs.Cook;

public class FoodCounter extends Environment {

    public FoodCounter() {
        super("Food Counter", "You walk up to the food counter. It smells like fried everything.");
        
        Cook cook = new Cook();
        addPerson(cook);
    }

    @Override
    public void enter(Person person) {
        super.enter(person);
    }

    private boolean tryCharge(Player player, double price) {
        if (player.getMoneyAmount() >= price) {
            player.addMoney(-price);
            return true;
        } else {
            System.out.println("You don't have enough money for that.");
            return false;
        }
    }

    public void buyBurger(Player player) {
        double price = 8.0;
        if (tryCharge(player, price)) {
            player.inventoryAdd(new Burger());
            System.out.println("You buy a burger for $" + price + ".");
        }
    }

    public void buyFries(Player player) {
        double price = 4.0;
        if (tryCharge(player, price)) {
            player.inventoryAdd(new Fries());
            System.out.println("You buy some fries for $" + price + ".");
        }
    }

    public void buySoda(Player player) {
        double price = 3.0;
        if (tryCharge(player, price)) {
            player.inventoryAdd(new Soda());
            System.out.println("You buy a soda for $" + price + ".");
        }
    }
}
