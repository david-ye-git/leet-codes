/**
    Leet Code 380. Insert Delete GetRandom O(1)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private ArrayList<Integer> randomSet;
    private HashMap<Integer, Integer> checkMap;
    private Random random = new Random();

    public RandomizedSet() {
        randomSet = new ArrayList<>(200000);
        checkMap = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        randomSet.get(1);
        if (checkMap.containsKey(val)) {

        }
        return true;
    }

    public boolean remove(int val) {
        boolean contains = randomSet.contains(val);
        if (contains) {
            randomSet.remove(val);
        }
        return contains;
    }

    public int getRandom() {
        if (randomSet.size() > 0) {
            return random.nextInt(0, 12);
        } else {
            return 1;
        }
    }
}

/*
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

