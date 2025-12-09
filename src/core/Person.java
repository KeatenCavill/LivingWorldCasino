package core;

import java.util.List;


public class Person {

    protected String name;
    protected int age;

    protected int peeMeter;
    protected int drunkMeter;
    protected int grubMeter;
    protected int thirstMeter;

    protected List<Item> inventory;

    public Person(String name,int age,int[] startingMeters, List<Item> startingInventory){
        this.name = name;
        this.age = age;

        this.peeMeter = startingMeters[0];
        this.drunkMeter = startingMeters[1];
        this.grubMeter = startingMeters[2];
        this.thirstMeter = startingMeters[3];

        this.inventory = startingInventory;
    }

    public String getName(){ return this.name; }
    public int getAge(){ return this.age; }

    public int getPeeMeter(){ return this.peeMeter; }
    public int getDrunkMeter(){ return this.drunkMeter; }
    public int getGrubMeter(){ return this.grubMeter; }
    public int getThirstMeter(){ return this.thirstMeter; }

    public List<Item> getInventory(){ return this.inventory; }

    public void changeDrunk(int delta){ this.drunkMeter = clamp(this.drunkMeter + delta); }
    public void changePee(int delta){ this.peeMeter = clamp(this.peeMeter + delta); }
    public void changeGrub(int delta) { this.grubMeter = clamp(this.grubMeter + delta); }
    public void changeThirst(int delta) { this.thirstMeter = clamp(this.thirstMeter + delta); }
    
     private static int clamp(int value){
        if (value<0) return 0;
        if (value>100) return 100;
        return value;
    }
}