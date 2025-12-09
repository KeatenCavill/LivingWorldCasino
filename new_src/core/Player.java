package core;

import java.util.List;


public class Player extends Person {

    private int phoneBattery;
    private double moneyAmount;
    
    public Player(String name, int age, int[] startingMeters, int battery, double money){
        super(name, age, startingMeters, List.of());
        this.phoneBattery = battery;
        this.moneyAmount  = money;
    }

    public void pickUp(Item item){
        if (item == null) return;
        this.inventory.add(item);
        System.out.println("You picked up " + item.getName() + ".");
    }

    public void throwAway(Item item){
        if (item == null) return;
        this.inventory.remove(item);
        System.out.println("You throw " + item.getName() + " in the nearest trash.");
    }

    public void inventoryAdd(Item item){
        pickUp(item);
    }

    public double getmoneyAmount(){ return this.moneyAmount; }

    public double getMoneyAmount(){ return this.moneyAmount; }

    public void receiveMoney(double increase){ this.moneyAmount += increase; }
    public void spendMoney(double decrease){ this.moneyAmount -= decrease; }

    public void addMoney(double delta){ this.moneyAmount += delta; }

    public int getPhoneBattery(){ return this.phoneBattery; }

    public void chargePhone(int mins){
        this.phoneBattery += mins * (100 / 60);
        if (this.phoneBattery > 100){ this.phoneBattery = 100; }
        System.out.println("You spent " + mins + " minutes charging your phone and got it up to " + this.phoneBattery + "% charged.");
    }

    public void displayStatus(){
        System.out.printf(
            "%s | Hunger: %d  Drunk: %d  Pee: %d  Money: $%.2f%n",
            name, grubMeter, drunkMeter, peeMeter, moneyAmount
        );
    }
}
