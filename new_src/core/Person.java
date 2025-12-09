package core;

import java.util.ArrayList;
import java.util.List;


public class Person {

    protected String name;
    protected int age;

    protected int peeMeter;
    protected int drunkMeter;
    protected int grubMeter;
    protected int thirstMeter;

    protected int happieness;  
    protected int aggression;
    protected int awareness;

    protected double fightLikelihood;
    protected double stealDifficulty;

    protected Environment location;

    protected List<Item> inventory;

    public Person(String name, int age, int[] startingMeters, List<Item> startingInventory){
        this.name = name;
        this.age  = age;

        if (startingMeters == null || startingMeters.length < 4){
            this.peeMeter    = 0;
            this.drunkMeter  = 0;
            this.grubMeter   = 0;
            this.thirstMeter = 0;
        } else {
            this.peeMeter    = startingMeters[0];
            this.drunkMeter  = startingMeters[1];
            this.grubMeter   = startingMeters[2];
            this.thirstMeter = startingMeters[3];
        }

        this.happieness = 50;
        this.aggression = 0;
        this.awareness  = 50;

        this.fightLikelihood = 0.3;
        this.stealDifficulty = 0.5;

        this.inventory = (startingInventory != null)
                ? startingInventory
                : new ArrayList<>();

        this.location = null;
    }

    public String getName(){ return this.name; }
    public int getAge(){ return this.age; }

    public int getPeeMeter(){ return this.peeMeter; }
    public int getDrunkMeter(){ return this.drunkMeter; }
    public int getGrubMeter(){ return this.grubMeter; }
    public int getThirstMeter(){ return this.thirstMeter; }

    public int getHappieness(){ return this.happieness; }
    public int getAggression(){ return this.aggression; }
    public int getAwareness(){ return this.awareness; }

    public double getFightLikelihood(){ return this.fightLikelihood; }
    public double getStealDifficulty(){ return this.stealDifficulty; }

    public Environment getLocation(){ return this.location; }
    public void setLocation(Environment env){ this.location = env; }
 
    public void move(Environment target){
        if (target == null) return;
        if (this.location != null){
            this.location.leave(this);
        }
        target.enter(this);
    }

    public List<Item> getInventory(){ return this.inventory; }

    public void changeDrunk(int delta){ this.drunkMeter = clampInt(this.drunkMeter + delta); }
    public void changePee(int delta){ this.peeMeter = clampInt(this.peeMeter + delta); }
    public void changeGrub(int delta) { this.grubMeter = clampInt(this.grubMeter + delta); }
    public void changeThirst(int delta) { this.thirstMeter = clampInt(this.thirstMeter + delta); }

    public void changeHappieness(int delta){ this.happieness = clampInt(this.happieness + delta); }
    public void changeAggression(int delta){ this.aggression = clampInt(this.aggression + delta); }
    public void changeAwareness(int delta){ this.awareness = clampInt(this.awareness + delta); }

    public void relieveOneSelf(){
        this.peeMeter = 0;
    }

    protected static int clampInt(int value){
        if (value < 0) return 0;
        if (value > 100) return 100;
        return value;
    }

    protected double clamp(double value, double min, double max){
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}