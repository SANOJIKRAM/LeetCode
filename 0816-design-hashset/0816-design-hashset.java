class MyHashSet {

    private static final int SIZE = 10000;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int idx = hash(key);
        if (buckets[idx] == null) {
            buckets[idx] = new LinkedList<>();
        }
        if (!buckets[idx].contains(key)) {
            buckets[idx].add(key);
        }
    }

    public void remove(int key) {
        int idx = hash(key);
        if (buckets[idx] != null) {
            buckets[idx].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        int idx = hash(key);
        return buckets[idx] != null && buckets[idx].contains(key);
    }
}
