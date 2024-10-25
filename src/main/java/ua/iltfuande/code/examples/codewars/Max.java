package ua.iltfuande.code.examples.codewars;

public class Max {

    public static int sequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        var max = Math.max(arr[0], 0);
        var sum = max;
        for (var num : arr) {
            sum += num;
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}