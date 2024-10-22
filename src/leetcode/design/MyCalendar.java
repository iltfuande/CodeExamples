package leetcode.design;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    private final List<Range> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        var range = new Range(start, end);
        var booked = containsRange(range);

        if (!booked) {
            calendar.add(range);
        }
        return !booked;
    }

    private boolean containsRange(Range range) {
        for (var element : calendar) {
            var start = element.start;
            var end = element.end;
            if (start <= range.start && range.start < end) {
                return true;
            } else if (start < range.end && range.end <= end) {
                return true;
            } else if (range.start <= start && start < range.end) {
                return true;
            } else if (range.start <= end && end < range.end) {
                return true;
            }
        }
        return false;
    }

    private record Range(int start, int end) {}
}