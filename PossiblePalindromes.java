import java.util.HashMap;

public class PossiblePalindromes {

    public static void possiblePalindromes(int currentState, int len, HashMap<Character, Integer> map, String oddChar,
            String ans) {
        if (currentState > len) {
            String rev = "";
            for (int i = ans.length() - 1; i >= 0; i--) {
                rev += ans.charAt(i);
            }
            String result = ans;

            if (oddChar != null)
                result += oddChar;

            result += rev;

            System.out.println(result);

            return;
        }

        for (char ch : map.keySet()) {
            int freq = map.get(ch);

            if (freq > 0) {
                map.put(ch, freq - 1);
                possiblePalindromes(currentState + 1, len, map, oddChar, ans + ch);
                map.put(ch, freq);
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabbc";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int val = map.get(str.charAt(i));
                map.put(str.charAt(i), val + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        System.out.println(map);

        String oddChar = "";
        int odds = 0;
        int len = 0;

        for (char ch : map.keySet()) {
            int freq = map.get(ch);

            if (freq % 2 == 1) {
                oddChar = ch + "";
                odds++;
            }
            map.put(ch, freq / 2);
            len += freq / 2;

        }
        System.out.println(oddChar);
        System.out.println(odds);

        if (odds > 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(map);
        System.out.println(len);

        String ans = "";
        possiblePalindromes(1, len, map, oddChar, ans);
    }

}