class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random rd;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rd = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val);
        int last = list.get(list.size()-1);
        int temp = list.get(pos);
        list.set(pos, last);
        map.put(last, pos);
        list.set(list.size()-1, temp);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rd.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */