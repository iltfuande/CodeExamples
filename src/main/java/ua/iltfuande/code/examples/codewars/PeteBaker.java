package ua.iltfuande.code.examples.codewars;

import java.util.Map;

public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
        int min = Integer.MAX_VALUE;
        if (available.isEmpty()) {
            return 0;
        }

        for (Map.Entry<String, Integer> entry : recipe.entrySet()) {
            var product = entry.getKey();
            var count = entry.getValue();

            if (!available.containsKey(product)) {
                return 0;
            }

            var availableCount = available.get(product);
            min = Math.min(min, availableCount / count);
        }
        return min;
    }
}
