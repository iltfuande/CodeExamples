package codewars;

public class RgbToHex {

    public static String rgb(int r, int g, int b) {
        return String.format("%02X%02X%02X", getCorrectRange(r), getCorrectRange(g), getCorrectRange(b));
    }

    private static int getCorrectRange(int number) {
        if (number > 255) {
            return 255;
        } else if (number < 0) {
            return 0;
        }
        return number;
    }
}