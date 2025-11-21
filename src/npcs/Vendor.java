package npcs;
import core.Item;


interface Vendor {
    void displayGoods(Item[] forSale);
    void buyItem(Item item);
}
