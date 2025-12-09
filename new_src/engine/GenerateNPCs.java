package engine;

import core.NPC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class GenerateNPCs {

    public static List<String> loadNames() {
        try {
            return Files.readAllLines(Path.of("src/core/names.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            return List.of("name error","what happened?","names.txt reading failed");
        }
    }

    public List<NPC> GenerateNPCs(){
        Random random = new Random();
        int numNPCs = random.nextInt(10,40);
        List<String> names = loadNames();
        int nameIdx;
        int randAge;
        int[] startingMeters;

        List<NPC> npcs = new ArrayList<>();
        for (int i = 0; i < numNPCs; i++){
            nameIdx = random.nextInt(names.size()-1);
            randAge = random.nextInt(20,71);
            startingMeters = new int[] {random.nextInt(101),
                                        random.nextInt(101),
                                        random.nextInt(101),
                                        random.nextInt(101)};
            npcs.add(NPC(names.get(nameIdx),startingMeters));
        }
    }
}
