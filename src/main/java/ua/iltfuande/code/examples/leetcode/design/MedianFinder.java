package ua.iltfuande.code.examples.leetcode.design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty() || num < minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        var min = minHeap.peek();
        var max = maxHeap.peek();

        if (minHeap.size() == maxHeap.size()) {
            return (max + min) / 2.0;
        }
        if (maxHeap.isEmpty() || minHeap.size() > maxHeap.size()) {
            return min;
        }
        return max;
    }
}
