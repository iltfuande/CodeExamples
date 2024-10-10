package leetcode.design;

import java.util.TreeMap;

public class Trie {

    private final TreeMap<String, String> container;

    public Trie() {
        container = new TreeMap<>();
    }
    
    public void insert(String word) {
        container.put(word.toLowerCase(), null);
    }
    
    public boolean search(String word) {
        return container.containsKey(word.toLowerCase());
    }
    
    public boolean startsWith(String prefix) {
        prefix = prefix.toLowerCase();
        var match = container.ceilingEntry(prefix);
        return match != null && match.getKey().startsWith(prefix);
    }
}