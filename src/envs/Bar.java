package envs;
import core.Environment;
import core.NPC;
import core.Person;
import core.Player;
import items.Beer;
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
}
