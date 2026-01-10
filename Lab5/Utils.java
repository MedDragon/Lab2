package sample;

public class Utils {
    public static int computeFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    public static String concatWords(String... words) {
        StringBuilder sb = new StringBuilder();
        for (String w : words) sb.append(w);
        return sb.toString();
    }

    public static String normalizeWord(String word) {
        return word.trim().toLowerCase();
    }
}