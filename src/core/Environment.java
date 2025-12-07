package core;


public class Environment {
    String name;
    String entranceMessage;
    
    private final List<Environment> connnectedAreas = new ArrayList<>();
    private final List<NPC> people = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();

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
        if (!people.contains(person)){
            people.add((NPC) person);
            person.setLocation(this);
            System.out.println(entranceMessage);
        }

    }

    public void stay(Person person){
        // Logic for when a person stays in the environment
        // if they are on the dance floor for too long they will get tired
    }

    public void leave(Person person){
        people.remove(person);
    }

    public void moveTo(Environment target){
        if (location != null){
            location.exit(this);
        }
        location = target;
        target.enter(this);
    }

    public Option<Item> TakeItemByName(String name){
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                items.remove(item);
                return Option.of(item);
            }
        }
        return Option.none();
    }

    public List<Item> getItems(){
        return Collections.unmodifiableList(items);
    }

    public List<NPC> getPeople(){
        return Collections.unmodifiableList(people);
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

  
