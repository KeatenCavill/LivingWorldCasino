package npcs;
import core.Item;


interface Vendor {
    void displayGoods();
    void buyItem(Item item);
}
