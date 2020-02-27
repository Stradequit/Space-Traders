package spacetraders.classes;

import java.util.HashMap;

public class ItemInventory {
    private int capacity = 0;
//    private HashMap goodMap = new HashMap(25);
    private HashMap <Good, Integer> goodMap;
    private int size = 0;
    public ItemInventory() {
        capacity = 3;
        goodMap = new HashMap<Good, Integer>(capacity);
    }
    public void addGood(Good good) {
        if (size < capacity) {
            if (goodMap.containsKey(good)) {
                int val = goodMap.get(good) + 1;
                goodMap.replace(good, val);
            } else {
                goodMap.put(good, 1);
            }
            size++;
        }
    }
    public void removeGood(Good good) {
        if (goodMap.containsKey(good)) {
            if (goodMap.get(good) == 1) {
                goodMap.remove(good);
            } else {
                int val = goodMap.get(good) - 1;
                goodMap.replace(good, val);
            }
            size--;
        }
    }
    public int getNumberOfGood(Good good) {
        return goodMap.getOrDefault(good, 0);
    }
    public void setCapacity (int capacity) {
        this.capacity = capacity;
    }
}
