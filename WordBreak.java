import java.util.HashSet;

class WordBreak {
    public static void wordBreak(String str, String ans, HashSet<String> dictionary) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            if (dictionary.contains(left)) {
                String right = str.substring(i + 1);
                wordBreak(right, ans + left + " ", dictionary);
            }
        }
    }

    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("microsoft");
        dictionary.add("hiring");
        dictionary.add("micro");
        dictionary.add("soft");
        dictionary.add("hi");
        dictionary.add("ring");

        String str = "microsofthiring";
        String ans = "";

        wordBreak(str, ans, dictionary);
    }
}