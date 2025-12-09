package userinterface;

import core.Environment;
import java.util.Scanner;


public class UserIO {

    private UserIO() { /* utility class - no instances */ }

    public static void pause(Scanner in, Environment env){
        System.out.println("You are currently in: " + (env != null ? env.getName() : "nowhere"));
        System.out.println("Press ENTER to continue...");
        in.nextLine();
    }
}
