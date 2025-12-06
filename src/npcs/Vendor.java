package npcs;
import core.Player;


interface Vendor {
    void displayGoods();
    void buyItem(int item, Player player);
}
