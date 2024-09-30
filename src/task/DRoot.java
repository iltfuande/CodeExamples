package task;

import java.util.Arrays;

public class DRoot {

    public static int digital_root(int n) {
        if (n < 10) {
            return n;
        }

        var sum = Arrays.stream(Integer.toString(n).split(""))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return digital_root(sum);
    }
}