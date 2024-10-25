package ua.iltfuande.code.examples.leetcode.design;

public class NumArray {

    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        var result = 0;
        for (int i = left; i <= right; i++) {
            result += nums[i];
        }
        return result;
    }
}