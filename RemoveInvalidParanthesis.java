import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParanthesis {

    public static void removeInvalidParanthesis(String str, int allowRemoval, HashSet<String> ans) {

        if (allowRemoval >= 0) {
            if (getMinRemoval(str) == 0) {
                if (!ans.contains(str)) {
                    System.out.println(str);
                    ans.add(str);
                }
            }

            if (allowRemoval == 0)
                return;

        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);

            removeInvalidParanthesis(left + right, allowRemoval - 1, ans);
        }
    }

    public static int getMinRemoval(String str) {

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                s.push(ch);
            } else {
                if (s.empty())
                    s.push(ch);

                else if (s.peek() == '(')
                    s.pop();
                else if (s.peek() == ')')
                    s.push(ch);
            }
        }
        // System.out.println(s);

        return s.size();

    }

    public static void main(String[] args) {
        String str = "(()(())()))";
        int allowRemoval = 2;

        HashSet<String> ans = new HashSet<>();

        removeInvalidParanthesis(str, allowRemoval, ans);
    }
}
