import leetcode.design.MedianFinder;

public class Main {

    public static void main(String[] args) {
        var root = new MedianFinder();
        root.addNum(2);
        root.addNum(3);
        root.addNum(-5);
        root.addNum(8);
        System.out.println(root.findMedian());
    }
}