package engine;

import core.Environment;
import core.Player;
import envs.*;


public class GameInitializer {

    public static Environment createWorld(Player player){
        
        FrontSidewalk frontSidewalk = new FrontSidewalk();
        Bar            bar          = new Bar();
        Bathroom       bathroom     = new Bathroom();
        DanceFloor     danceFloor   = new DanceFloor();
        FoodCounter    foodCounter  = new FoodCounter();
        OpenTable      openTable    = new OpenTable();
        SlotMachines   slotMachines = new SlotMachines();
        Alley          alley        = new Alley();

        
        frontSidewalk.connectedTo(bar);
        frontSidewalk.connectedTo(alley);

        bar.connectedTo(bathroom);
        bar.connectedTo(danceFloor);
        bar.connectedTo(foodCounter);
        bar.connectedTo(openTable);
        bar.connectedTo(slotMachines);
        bar.connectedTo(frontSidewalk);

        danceFloor.connectedTo(openTable);
        foodCounter.connectedTo(openTable);
        slotMachines.connectedTo(openTable);

        alley.connectedTo(frontSidewalk);

        frontSidewalk.enter(player);

        return frontSidewalk;
    }
}
