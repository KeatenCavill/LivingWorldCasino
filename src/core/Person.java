package core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import envs.*;

public class Person {
    public String name;
    public int age;

    protected double peeMeter;
    protected double drunkMeter;
    protected double grubMeter;
    protected double thirstMeter;

    protected double happiness;
    protected double aggression;
    protected double awareness;

    protected Environment location;
    protected final List<Item> inventory = new ArrayList<>();

    public double clamp(double value, double min, double max){
        if (value<min) return min;
        if (value>max) return max;
        return value;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    void setLocation(Environment env){
        this.location = env;
    }

    public void pickUp(String itemName){
        if (location == null) return;

        Optional<Item> maybe = location.TakeItemByName(itemName);
        if (maybe.isPresent()){
            Item item = maybe.get();
            // Add the item to this person's inventory
            inventory.add(item);
            System.out.println(name + " picked up " + item.getName() + ".");
        } else {
            System.out.println("No " + itemName + " found here.");
        }
    }

    /**
     * Consume an item from this person's inventory by name. If the item is
     * consumable it will apply its effects and be removed from inventory.
     */
    public void consumeItem(String itemName){
        if (itemName == null) return;
        String query = itemName.trim().toLowerCase();

        Item found = null;
        // first try exact match
        for (Item it : new ArrayList<>(inventory)){
            if (it.getName().equalsIgnoreCase(itemName)){
                found = it;
                break;
            }
        }

        // then try contains
        if (found == null){
            for (Item it : new ArrayList<>(inventory)){
                if (it.getName().toLowerCase().contains(query)){
                    found = it;
                    break;
                }
            }
        }

        if (found == null){
            System.out.println("You don't have a '" + itemName + "' to consume.");
            return;
        }

        // If the item implements items.Consumable, call its consume method.
        if (found instanceof items.Consumable){
            ((items.Consumable) found).consume(this);
            // remove from inventory after consumption
            inventory.remove(found);
            System.out.println(found.getName() + " has been removed from your inventory.");
        } else {
            System.out.println("You can't consume " + found.getName() + ".");
        }
    }
    

    public void changeDrunk(double delta) { drunkMeter = clamp(drunkMeter + delta, 0, 100); }
    public void changePee(double delta) { peeMeter = clamp(peeMeter + delta, 0, 100); }
    public void changeGrub(double delta) { grubMeter = clamp(grubMeter + delta, 0, 100); }
    public void changeThirst(double delta) { thirstMeter = clamp(thirstMeter + delta, 0, 100); }

    public void changeHappieness(double delta) { happiness = (int) clamp(happiness + delta, 0, 100); }
    public void changeAggression(double delta) { aggression = (int) clamp(aggression + delta, 0, 100); }
    public void changeAwareness(double delta) { awareness = (int) clamp(awareness + delta, 0, 100); }

    public List<Item> getInventory(){
     return Collections.unmodifiableList(inventory); 
    }
    
    public void relieveOneSelf(){
        if(this.location instanceof Bathroom){
            this.peeMeter = 0;
            System.out.println(this.name + " has relieved themselves.");
        } else if(this.location instanceof Alley || this.location instanceof FrontSidewalk){
            this.peeMeter = 0;
            System.out.println(this.name + " has relieved themselves.");
        } else {
            System.out.println(this.name + "has tried to relieve themselves in the " + this.location + ".");
            System.out.println("A passersby yelled at them: \"Ew! You can't do that here!\"");}
        }

    public double getPeeMeter(){ return peeMeter; }
    public double getDrunkMeter(){ return drunkMeter; }
    public double getGrubMeter(){ return grubMeter; }
    public double getThirstMeter(){ return thirstMeter; }
    public double getHappiness(){ return happiness; }
    public double getAggression(){ return aggression; }
    public double getAwareness(){ return awareness; }

    public double getStealDifficulty(){
        double difficulty = 0;
        difficulty -= drunkMeter * 0.5;
        difficulty += awareness * 0.3;
        difficulty += aggression * 0.8;
        return clamp(difficulty, 0, 100);
    }

    public double getFightLikelihood(){
        double chance = 0;

        chance += drunkMeter * 0.6;
        chance += aggression * 0.7;
        chance -= happiness * 0.4;
        return (int) clamp(chance, 0, 100);
    }
}