package core;


public class Player extends Person {

    private int phoneBattery;
    private double moneyAmount;
    

    public Player(String name, int age, double money){
        super(name, age);
        this.phoneBattery = 100;
        this.moneyAmount = money;
    }

    public void inventoryAdd(Item item){ this.inventory.add(item); }
    public void inventoryRemove(Item item){ this.inventory.remove(item); }

    public double getMoneyAmount(){return(this.moneyAmount);}
    public void addMoney(double increase){this.moneyAmount = this.moneyAmount + increase;}

    public int getPhoneBattery(){return(this.phoneBattery);}
    public void chargePhone(int mins){
        this.phoneBattery = this.phoneBattery + (int)(mins * (100/60));
        if(this.phoneBattery > 100){this.phoneBattery = 100;}
        System.out.println("You spent " + mins + " charging your phone and got it up to " + this.phoneBattery + "% charged.");
    }

    void displayStatus(){
        System.out.printf(
            "%s | Hunger : %d Drunk: %d Pee: %d Money: $%.2f%n",
            name, grubMeter, drunkMeter, peeMeter, moneyAmount
        );

    }

    void displayInventory(){
        System.out.println("Inventory:");
        for (Item item : getInventory()) {
            System.out.println("- " + item.getName());
        }

    }

    public void changeMoney(double delta) {
        this.moneyAmount += delta;
    }

    public double getMoney(){
        return this.moneyAmount;
    }
    

}
