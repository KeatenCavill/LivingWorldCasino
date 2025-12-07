package items;
import core.Item;
import core.Person;


public class Soda extends Item implements Consumable{
    public Soda(){
        this.name = "Soda";
        this.description = "A fizzy carbonated drink to quench your thirst.";
        this.monetaryValue = 2.0;
    }

    @Override
    public void consume(Person person){
        person.changeThirst(-10);
        person.changePee(7);
        person.changeHappiness(20);
        person.changeAwareness(10); // Caffeine boost >:D
        person.changeAggression(-5);
        System.out.println(person.name + " drinks the soda. Thirst decreased!");
    }
}
   
