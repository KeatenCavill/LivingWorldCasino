package core;


public class Item {
    protected final String name;
    protected final String description;
    protected final double monetaryValue;

    public Item(String name, String description, double Value){
        this.name = name;
        this.description = description;
        this.monetaryValue = Value;
    }

    public String getName(){return this.name;}
    public double getMonetaryValue(){return this.monetaryValue;}
    public String getDescription(){return this.description;}

}
