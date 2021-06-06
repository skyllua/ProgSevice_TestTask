import java.util.Arrays;

public class InnerEntry {
    private int capacity = 2;
    private int size;
    private Entry[] entries;

    public InnerEntry() {
        size = 0;
        entries = new Entry[capacity];

        for (int i = 0; i < capacity; i++) {
            entries[i] = new Entry(null, null);
        }
    }
    
    public void put(int key, long value) {
        if (!isCreated(key)) {
            if (size + 1 >= capacity) expandCapacity();

            entries[size++] = new Entry(key, value);
        } else {
            for (Entry entry : entries) {
                if (entry.getKey() != null) {
                    if (entry.getKey() == key) {
                        entry.setValue(value);
                        break;
                    }
                }
            }
        }
    }

    private boolean isCreated(int key) {
        boolean trigger = false;

        for (Entry entry : entries) {
            if (entry.getKey() != null) {
                if (entry.getKey() == key) {
                    trigger = true;
                    break;
                }
            }
        }

        return trigger;
    }
    
    public Long get(int key) {
        Long value = null;

        for (Entry entry : entries) {
            if (entry.getKey() != null) {
                if (entry.getKey() == key) {
                    value = entry.getValue();
                    break;
                }
            }
        }
        
        return value;
    }

    public Entry[] getEntries() {
        return entries;
    }

    private void expandCapacity() {
        entries = Arrays.copyOf(entries, capacity*2);

        for (int i = capacity; i < capacity*2; i++) {
            entries[i] = new Entry(null, null);
        }

        capacity *= 2;
    }
    
    public int size() {
        return size;
    }
}
