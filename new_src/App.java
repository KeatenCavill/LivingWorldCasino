import core.Environment;
import core.Item;
import core.NPC;
import core.Person;
import core.Player;
import engine.GameInitializer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the Bar Game!");

        System.out.print("What is your name? ");
        String name = in.nextLine().trim();
        if (name.isEmpty()){
            name = "Player";
        }

        int age = 0;
        while (true){
            System.out.print("How old are you? ");
            String line = in.nextLine().trim();
            try {
                age = Integer.parseInt(line);
                if (age <= 0){
                    System.out.println("Please enter a positive age.");
                    continue;
                }
                break;
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid integer for age.");
            }
        }

        int[] startingMeters = new int[]{ 10, 0, 50, 40 };
        int startingBattery  = 50;
        double startingMoney = 40.0;

        Player player = new Player(name, age, startingMeters, startingBattery, startingMoney);

        Environment current = GameInitializer.createWorld(player);

        System.out.println();
        System.out.println("Okay, " + name + ", let's go out! Type 'help' for commands.");

        gameLoop(in, player, current);

        in.close();
    }

    private static void gameLoop(Scanner in, Player player, Environment startEnv){
        Environment current = startEnv;

        boolean running = true;
        while (running){
            System.out.println();
            printEnvironmentView(current, player);

            System.out.print("> ");
            String line = in.nextLine().trim();

            if (line.isEmpty()){
                continue;
            }

            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();

            switch (cmd){
                case "help" -> printHelp();
                case "look" -> {
                }
                case "status" -> player.displayStatus();
                case "inventory" -> printInventory(player);
                case "move", "go" -> {
                    if (parts.length < 2){
                        System.out.println("Usage: move <number>"); 
                        break;
                    }
                    try {
                        int idx = Integer.parseInt(parts[1]);
                        current = handleMove(player, current, idx);
                    } catch (NumberFormatException e){
                        System.out.println("Environment index must be a number.");
                    }
                }
                case "take", "get" -> {
                    if (parts.length < 2){
                        System.out.println("Usage: take <number>"); 
                        break;
                    }
                    try {
                        int idx = Integer.parseInt(parts[1]);
                        handleTake(player, current, idx);
                    } catch (NumberFormatException e){
                        System.out.println("Item index must be a number.");
                    }
                }
                case "talk" -> {
                    if (parts.length < 2){
                        System.out.println("Usage: talk <number>"); 
                        break;
                    }
                    try {
                        int idx = Integer.parseInt(parts[1]);
                        handleTalk(player, current, idx);
                    } catch (NumberFormatException e){
                        System.out.println("NPC index must be a number.");
                    }
                }
                case "quit", "exit" -> {
                    System.out.println("Thanks for playing. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Unknown command. Type 'help' for a list of commands.");
            }
        }
    }

    private static void printHelp(){
        System.out.println("Available commands:");
        System.out.println("  look                - re-print the current area");
        System.out.println("  move <n> / go <n>   - move to connected area #n");
        System.out.println("  take <n> / get <n>  - pick up item #n in this area");
        System.out.println("  talk <n>            - talk to NPC #n in this area");
        System.out.println("  inventory           - list items you're carrying");
        System.out.println("  status              - show your meters & money");
        System.out.println("  help                - show this help text");
        System.out.println("  quit                - leave the game");
    }

    private static void printEnvironmentView(Environment env, Player player){
        System.out.println("==================================================");
        System.out.println("You are in: " + env.getName());
        env.displayInfo();

        // Connected areas
        List<Environment> neighbors = env.getConnectedAreas();
        if (!neighbors.isEmpty()){
            System.out.println();
            System.out.println("Places you can go:");
            for (int i = 0; i < neighbors.size(); i++){
                System.out.printf("  %d) %s%n", i + 1, neighbors.get(i).getName());
            }
        }

        // People in this environment
        List<Person> people = env.getPeople();
        List<NPC> npcs = new ArrayList<>();
        for (Person p : people){
            if (p == player) continue;
            if (p instanceof NPC npc){
                npcs.add(npc);
            }
        }

        if (!npcs.isEmpty()){
            System.out.println();
            System.out.println("People here:");
            for (int i = 0; i < npcs.size(); i++){
                System.out.printf("  %d) %s%n", i + 1, npcs.get(i).getName());
            }
        }

        // Items available
        List<Item> items = env.getItems();
        if (!items.isEmpty()){
            System.out.println();
            System.out.println("Items you see:");
            for (int i = 0; i < items.size(); i++){
                Item it = items.get(i);
                System.out.printf("  %d) %s ($%.2f)%n", i + 1, it.getName(), it.getMonetaryValue());
            }
        }

        System.out.println("==================================================");
        System.out.println("Type 'help' for commands.");
    }

    private static void printInventory(Player player){
        List<Item> inv = player.getInventory();
        if (inv.isEmpty()){
            System.out.println("Your inventory is empty.");
            return;
        }
        System.out.println("You are carrying:");
        int i = 1;
        for (Item it : inv){
            System.out.printf("  %d) %s%n", i++, it.getName());
        }
    }

    private static Environment handleMove(Player player, Environment current, int index){
        List<Environment> neighbors = current.getConnectedAreas();
        if (index < 1 || index > neighbors.size()){
            System.out.println("No environment with that index.");
            return current;
        }
        Environment target = neighbors.get(index - 1);
        current.moveTo(player, target);
        return target;
    }

    private static void handleTake(Player player, Environment env, int index){
        List<Item> items = env.getItems();
        if (index < 1 || index > items.size()){
            System.out.println("No item with that index.");
            return;
        }
        Item chosen = items.get(index - 1);
       
        java.util.Optional<Item> taken = env.TakeItemByName(chosen.getName());
        if (taken.isPresent()){
            player.pickUp(taken.get());
        } else {
            System.out.println("That item is no longer here.");
        }
    }

    private static void handleTalk(Player player, Environment env, int index){
        List<Person> people = env.getPeople();
        List<NPC> npcs = new ArrayList<>();
        for (Person p : people){
            if (p == player) continue;
            if (p instanceof NPC npc){
                npcs.add(npc);
            }
        }
        if (index < 1 || index > npcs.size()){
            System.out.println("No NPC with that index.");
            return;
        }
        NPC target = npcs.get(index - 1);
        target.talkTo();
    }
}
