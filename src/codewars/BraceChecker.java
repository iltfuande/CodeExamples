package codewars;

import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class BraceChecker {

    private static final Map<String, String> braceMap = Map.of(
            "{", "}",
            "(", ")",
            "[", "]"
    );

    public boolean isValid(String braces) {
        if (braces.length() % 2 != 0) {
            return false;
        }

        var stack = new Stack<String>();
        var split = braces.trim().split("");
        for (int i = 0; i < split.length; i++) {
            if (i == 0 && braceMap.containsValue(split[i])) {
                return false;
            }
            if (braceMap.containsKey(split[i])) {
                stack.push(split[i]);
            } else if (!stack.isEmpty() && Objects.equals(braceMap.get(stack.get(stack.size() - 1)), split[i])) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}