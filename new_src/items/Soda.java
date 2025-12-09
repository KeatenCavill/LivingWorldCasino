package items;

import core.*;


public class Soda extends Item implements Consumable{
    public Soda(){
        super("Soda", "A fizzy carbonated drink to quench your thirst.", 2.0);
    }

    @Override
    public void consume(Person person){
        if (person == null) return;
        person.changeThirst(-10);
        person.changePee(7);
        person.changeHappieness(20);
        person.changeAwareness(10); // Caffeine boost >:D
        person.changeAggression(-5);
        System.out.println(person.getName() + " drinks the soda. Thirst decreased!");
    }
}
   
