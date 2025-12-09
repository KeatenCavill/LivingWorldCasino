package userinterface;

import java.util.ArrayList;
import java.util.List;

import core.Environment;
import core.Item;
import core.NPC;
import core.Person;

/**
 * Utility methods for turning environment state into simple string options.
 * 
 * Currently not required by the main game loop, but kept so the original
 * structure of the project remains intact.
 */
public class PrintOptions {

    public static List<String> currentEnv(Environment env){
        List<String> options = new ArrayList<>();
        if (env == null) return options;
        int i = 1;
        for (Environment other : env.getConnectedAreas()){
            options.add(i + ": Go to " + other.getName());
            i++;
        }
        return options;
    }

    public static String currentItem(Item item){
        if (item == null) return "(no item)";
        return item.getName() + " - " + item.getDescription();
    }

    public static String currentNPC(NPC npc){
        if (npc == null) return "(no one)";
        return npc.getName();
    }
}
