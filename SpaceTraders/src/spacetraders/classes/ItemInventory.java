package spacetraders.classes;

import java.util.HashMap;

public class ItemInventory {
    private int capacity;
    private HashMap goodMap = new HashMap(capacity);
    private int size = 0;
    public void addGood(Good good) {
        if (size < capacity) {
            if (goodMap.containsKey(good)) {
                int val = (Integer) goodMap.get(good) + 1;
                goodMap.replace(good, val);
            } else {
                goodMap.put(good, 1);
            }
            size++;
        }
    }
    public void removeGood(Good good) {
        if (goodMap.containsKey(good)) {
            if ((Integer)goodMap.get(good) == 1) {
                goodMap.remove(good);
            } else {
                int val = (Integer)goodMap.get(good) - 1;
                goodMap.replace(good, val);
            }
            size--;
        }
    }
    public int getNumberOfGood(Good good) {
        if (goodMap.containsKey(good)) {
            return (Integer)goodMap.get(good);
        } else {
            return 0;
        }
    }
}
