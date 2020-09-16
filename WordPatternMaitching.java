import java.util.HashMap;
import java.util.HashSet;

public class WordPatternMaitching {

    public static void wordPatternMaitching(String str, String pattern, HashMap<Character, String> map,
            String originalPatt) {

        if (pattern.length() == 0) {
            if (str.length() == 0) {
                HashSet<Character> alreadyPrinted = new HashSet<>();
                for (int i = 0; i < originalPatt.length(); i++) {
                    char ch = originalPatt.charAt(i);
                    if (alreadyPrinted.contains(ch) == false) {
                        System.out.print(ch + "->" + map.get(ch) + " ");
                        alreadyPrinted.add(ch);
                    }
                }
                System.out.println(".");
            }
            return;
        }

        char ch = pattern.charAt(0);
        String remainingPattern = pattern.substring(1);

        if (map.containsKey(ch)) {

            String alreadyMapString = map.get(ch);

            if (str.length() >= alreadyMapString.length()) {
                String left = str.substring(0, alreadyMapString.length());
                String right = str.substring(alreadyMapString.length());

                if (alreadyMapString.equals(left))
                    wordPatternMaitching(right, remainingPattern, map, originalPatt);
            }

        } else {
            for (int i = 0; i < str.length(); i++) {
                String left = str.substring(0, i + 1);
                String right = str.substring(i + 1);

                map.put(ch, left);
                wordPatternMaitching(right, remainingPattern, map, originalPatt);
                map.remove(ch);
            }
        }
    }

    public static void main(String[] args) {
        String str = "mzaddytzaddy";
        String pattern = "abcb";
        String originalPatt = pattern;

        HashMap<Character, String> map = new HashMap<>();

        wordPatternMaitching(str, pattern, map, originalPatt);
    }
}
