package review;

import review.exercise2pkg.Key;
import java.util.HashMap;

public class TestExercise2 {
    public static void main(String[] args) {
        HashMap<Key, String> map = new HashMap<>();

        Key k1 = new Key("A");
        Key k2 = new Key("B");
        Key k3 = new Key("C");

        map.put(k1, "First");
        map.put(k2, "Second");
        map.put(k3, "Third");

        System.out.println("Map size: " + map.size());
        System.out.println("Value for k1: " + map.get(k1));
        System.out.println("Value for k2: " + map.get(k2));
        System.out.println("Value for k3: " + map.get(k3));

        System.out.println("Map contents: " + map);
    }
}
