import leetcode.design.LFUCache;
import leetcode.design.MedianFinder;

public class Main {

    public static void main(String[] args) {
        var root = new LFUCache(2);
        root.put(1, 1);
        root.put(2, 1);
        root.put(2, 2);
        root.put(3, 3);
        System.out.println(root.get(2));
    }
}