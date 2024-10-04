import codewars.BraceChecker;
import leetcode.design.LRUCache;


public class Main {

    public static void main(String[] args) {
        var lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);

    }
}