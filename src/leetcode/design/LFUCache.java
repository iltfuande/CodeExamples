package leetcode.design;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    private final int capacity;
    private final Map<Integer, LFUCacheEntry> cache;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        var entry = cache.get(key);
        if (entry != null) {
            cache.put(key, entry.incrementUsage());
            return entry.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            var entry = cache.get(key).incrementUsage();
            cache.put(key, new LFUCacheEntry(key, value, entry.frequency, entry.timestamp));
        } else {
            if (capacity == cache.size()) {
                removeLeastFrequentlyUsed();
            }
            cache.put(key, new LFUCacheEntry(key, value, 0, Instant.now()));
        }
    }

    private void removeLeastFrequentlyUsed() {
        var leastFrequentlyUsed = cache.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
        cache.remove(leastFrequentlyUsed);
    }

    private record LFUCacheEntry(int key, int value, int frequency, Instant timestamp) implements Comparable<LFUCacheEntry> {

        @Override
        public int compareTo(LFUCacheEntry other) {
            int frequencyComparison = Integer.compare(this.frequency, other.frequency);
            if (frequencyComparison != 0) {
                return frequencyComparison;
            }
            return this.timestamp.compareTo(other.timestamp);
        }

        public LFUCacheEntry incrementUsage() {
            return new LFUCacheEntry(key(), value(), frequency() + 1, Instant.now());
        }
    }
}