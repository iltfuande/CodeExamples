package task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickPeaks {
    
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        if (arr == null || arr.length < 3) {
            return formAnswer(Collections.emptyList(), Collections.emptyList());
        }

        var pos = new ArrayList<Integer>();
        var peaks = new ArrayList<Integer>();
        for (int i = 1; i < arr.length - 1; i++) {
            var prev = arr[i - 1];
            var current = arr[i];
            var next = arr[i + 1];

            if (current > prev && current == next) {
                var j = i + 1;
                while (j < arr.length && arr[j] == current) {
                    j++;
                }

                if (j < arr.length && arr[j] < current) {
                    pos.add(i);
                    peaks.add(current);
                }
                i = j - 1;
            } else if (current > prev && current > next) {
                pos.add(i);
                peaks.add(current);
            }
        }

        return formAnswer(pos, peaks);
    }

    private static HashMap<String, List<Integer>> formAnswer(List<Integer> pos, List<Integer> peaks) {
        return new HashMap<>() {{
            put("pos", pos);
            put("peaks", peaks);
        }};
    }
}
