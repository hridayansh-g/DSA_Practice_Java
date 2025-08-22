class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        map.put(last, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    //approach 1

    /*
    List<Integer> list;
    Random ran;
    
    public RandomizedSet() {
        list = new ArrayList<>();
        ran = new Random();
    }
    
    public boolean insert(int val) {
        if (list.contains(val))
            return false;
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        return list.remove((Integer) val);
    }
    
    public int getRandom() {
        return list.get(ran.nextInt(list.size()));
    }
    */
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */