package core;

import java.util.*;

public class Environment {
    String name;
    String entranceMessage;
    
    public final List<Environment> connnectedAreas = new ArrayList<>();
    public final List<Person> people = new ArrayList<>();
    public final List<Item> items = new ArrayList<>();

    protected Environment(String name, String entranceMessage){
        this.name = name;
        this.entranceMessage = entranceMessage;
    }

    public void connectedTo(Environment other) {
        if (!connnectedAreas.contains(other)) {
            connnectedAreas.add(other);
            other.connnectedAreas.add(this);
        }
    }

    public void enter(Person person){
        if (person == null) return;

        // If person is already in another environment, remove them from there first
        if (person.location != null && person.location != this){
            person.location.leave(person);
        }

        if (!people.contains(person)){
            people.add(person);
        }

        person.setLocation(this);
        System.out.println(entranceMessage);
    }

    public void stay(Person person){
       
    }

    public void leave(Person person){
        people.remove(person);
    }

    public void moveTo(Person person, Environment target){
        if (person == null || target == null) return;

        // Remove person from their current location if present
        if (person.location != null){
            person.location.leave(person);
        }

        // Enter the target environment
        target.enter(person);
    }

    public Optional<Item> TakeItemByName(String name){
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                items.remove(item);
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    public List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public List<Person> getPeople(){
        return Collections.unmodifiableList(people);
    }


    protected void addPerson(Person person){
        if (person == null) return;
        if (!people.contains(person)){
            people.add(person);
            person.setLocation(this);
        }
    }

    protected void addPeople(Person... persons){
        if (persons == null) return;
        for (Person p : persons) addPerson(p);
    }

    /**
     * Allow subclasses to add items to this environment during initialization.
     */
    protected void addItem(Item item){
        if (item == null) return;
        items.add(item);
    }

    protected void addItems(Item... things){
        if (things == null) return;
        for (Item it : things) addItem(it);
    }

    public List<Environment> getConnectedAreas(){
        return Collections.unmodifiableList(connnectedAreas);
    }

    public String getName(){
        return name;
    }

    public void displayInfo(){
        System.out.println("You are in: " + name);
        System.out.println("People here: " + people.size());
        System.out.println("Items available:");
        for (Item i : items) {
            System.out.println("- " + i.getName());
        }
    }
}

  
