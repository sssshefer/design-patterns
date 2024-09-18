package RPG;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> items;

    public Inventory(){
        items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public List<Item> getItems(){
        return items;
    }

    public Boolean isContainItem(Item item){
        return items.contains(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

}

