import java.util.*;

public class Runnable {
    private static final int COUNT = 1_000_000;
    private static final int MAX = 100_000_000;
    private static List<Integer> list = new ArrayList<>();

    private static MyHashMap map = new MyHashMap();
    private static Map<Integer, Integer> orig = new HashMap<>();

    public static void main(String[] args) {


        for (int i = 0; i < COUNT; i++) {
            int rnd = (int) (Math.random()*MAX);
            list.add(rnd);
        }

        long start = System.currentTimeMillis();
        putMy();
        System.out.println("Method put() with MY decision takes: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        putOrig();
        System.out.println("Method put() with Original decision takes: " + (System.currentTimeMillis() - start) + " ms");





        start = System.currentTimeMillis();
        getMy();
        System.out.println("\n\nget() my takes: " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        getOrig();
        System.out.println("get() ORIG takes: " + (System.currentTimeMillis() - start) + " ms");



        System.out.println("\n\n\nMY size(): " + map.size());
        System.out.println("ORIG size(): " + orig.size());
    }

    private static void putMy() {
        for (Integer i : list) {
            map.put(i, i);
            orig.put(i, i);
        }
    }

    private static void putOrig() {
        for (Integer i : list) {
            map.put(i, i);
            orig.put(i, i);
        }
    }

    private static void getMy() {
        for (Integer i : list) {
            map.get(i);
        }
    }

    private static void getOrig() {
        for (Integer i : list) {
            orig.get(i);
        }
    }

}
