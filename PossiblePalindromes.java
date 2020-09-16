import java.util.HashMap;

public class PossiblePalindromes {

    public static void possiblePalindromes(int currenState, int totalState, HashMap<Character, Integer> map,
            String oddChar, String ans) {

        if (currenState > totalState) {

            String rev = "";
            for (int i = ans.length() - 1; i >= 0; i--)
                rev += ans.charAt(i);

            String result = ans;

            if (oddChar != null)
                result += oddChar;

            result += rev;

            System.out.println(result);
            return;
        }

        for (char ch : map.keySet()) {
            int val = map.get(ch);

            if (val > 0) {
                map.put(ch, val - 1);
                possiblePalindromes(currenState + 1, totalState, map, oddChar, ans + ch);
                map.put(ch, val);
            }

        }
    }

    public static void main(String[] args) {
        String str = "aabbcc";

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                int freq = map.get(str.charAt(i));
                map.put(str.charAt(i), freq + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        System.out.println("Start=" + map);

        int odds = 0;
        String oddChar = "";
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

        System.out.println("after=" + map);
        System.out.println(oddChar + " " + oddChar.length());

        if (odds > 1) {
            System.out.println(-1);
            return;
        }
        String ans = "";

        possiblePalindromes(1, len, map, oddChar, ans);
    }
}
