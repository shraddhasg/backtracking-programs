class AllPossiblePalindromes {

    public static boolean isPalindrome(String str) {

        int l = 0, r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r))
                return false;

            l++;
            r--;
        }
        return true;

    }

    public static void allPossiblePalindromes(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
        }
        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);

            String remainingString = str.substring(i + 1);

            if (isPalindrome(prefix)) {
                allPossiblePalindromes(remainingString, ans + "(" + prefix + ") ");
            }
        }

    }

    public static void main(String[] args) {
        String str = "abaaba";
        String ans = "";

        allPossiblePalindromes(str, ans);
    }
}