package spacetraders.classes;

public class ItemInventory {
    private Good[] goodArray;
    private int[] goodNumber;
    private int capacity;
    public ItemInventory(int cargoCapacity) {
        this.capacity = cargoCapacity;
        goodArray = new Good[capacity];
        goodNumber = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            goodArray[i] = null;
            goodNumber[i] = 0;
        }
    }
    public void addGood(Good good, int i) {
        boolean goodSlot = false;
        if(goodArray[i].equals(null)) {
            goodArray[i] = good;
            goodNumber[i] += 1;
        } else if (goodArray[i].equals(good)) {
            goodNumber[i] += 1;
        } else {
            i++;
            addGood(good, i);
        }
    }
    public void removeGood(Good good, int i) {
        if (i < goodArray.length) {
            if (goodArray[i].equals(good)) {
                goodNumber[i]--;
                if (goodNumber[i] == 0) {
                    goodArray[i] = null;
                }
            } else {
                i++;
                removeGood(good, i);
            }
        }
    }
}
