public class MyHashMap {
    private int innerSize;
    private int capacity = 2048;
    private InnerEntry[] entries;

    public MyHashMap() {
        entries = new InnerEntry[capacity];

        for (int i = 0; i < capacity; i++) {
            entries[i] = new InnerEntry();
        }
    }

    public void put(int key, long value) {
        if (innerSize == capacity) expandCapacity();

        if (entries[key % capacity].size() == 0) innerSize++;

        entries[key % capacity].put(key, value);
    }

    public Long get(int key) {
        return entries[key % capacity].get(key);
    }

    public int size() {
        int size = 0;

        for (int i = 0; i < capacity; i++) {
            size += entries[i].size();
        }

        return size;

    }

    private void expandCapacity() {
        InnerEntry[] _entries = entries;
        entries = new InnerEntry[capacity*2];

        for (int i = 0; i < capacity*2; i++) {
            entries[i] = new InnerEntry();
        }

        innerSize = 0;
        for (int i = 0; i < capacity; i++) {
            for (Entry entry : _entries[i].getEntries()) {
                if (entry.getKey() != null) {
                    if (entries[entry.getKey() % (capacity * 2)].size() == 0) innerSize++;
                    entries[entry.getKey() % (capacity * 2)].put(entry.getKey(), entry.getValue());
                }
            }
        }

        capacity *= 2;
    }

//    private int innerSize() {
//        int size = 0;
//
//        for (int i = 0; i < capacity; i++) {
//            if (entries[i].size() > 0) size++;
//        }
//
//        return size;
//    }
}
