package userinterface;

import core.Environment;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserIO {
    

    static List<String> commands = List.of("status","inventory","back","help");


    static void input(Scanner inStream,Environment env){

        String input;
        Boolean validInput = false;
        List<String> options = PrintOptions.currentEnv(env);

        while (!validInput){
            try {
                input = inStream.nextLine();

                if (commands.contains(input)){

                    validInput = true;
                }
                else if (options.contains(input)){
                    input(inStream,)
                    validInput = true;
                }
                else {
                    validInput = false;
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Input must be an command or listed option.");
                System.out.println("For a list of commands, type help.");
                validInput = false;
            }
        }
    }
}
