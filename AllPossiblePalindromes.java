class AllPossiblePalindromes {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }

    public static void allPossiblePalindromes(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            String remainingStr = str.substring(i + 1);

            if (isPalindrome(prefix)) {
                allPossiblePalindromes(remainingStr, ans + "(" + prefix + ") ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabaa";
        String ans = "";

        allPossiblePalindromes(str, ans);
    }
}