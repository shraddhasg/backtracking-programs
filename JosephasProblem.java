public class JosephasProblem {
    public static int josephasProblem(int n, int k) {

        if (n == 1)
            return 0;

        int x = josephasProblem(n - 1, k);
        int y = (x + k) % n;

        return y;
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 3;

        System.out.println(josephasProblem(n, k));
    }
}
