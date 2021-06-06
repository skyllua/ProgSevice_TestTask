public class Entry {
    private final Integer key;
    private Long value;

    public Entry(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public Entry(Integer key, Long value) {
        this.key = key;
        this.value = value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Long getValue() {
        return value;
    }
}
