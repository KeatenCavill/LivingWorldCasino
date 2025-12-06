package npcs;
import core.Item;
import core.Player;


interface Vendor {
    void displayGoods();
    void buyItem(int item, Player player);
}
