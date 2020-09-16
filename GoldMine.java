import java.util.ArrayList;

public class GoldMine {

    public static void collectGold(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag) {

        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0 || visited[i][j] == true)
            return;

        bag.add(arr[i][j]);
        visited[i][j] = true;

        collectGold(arr, i - 1, j, visited, bag); // north
        collectGold(arr, i + 1, j, visited, bag); // south
        collectGold(arr, i, j + 1, visited, bag); // east
        collectGold(arr, i, j - 1, visited, bag); // west

    }

    public static int goldMine(int[][] arr) {

        int max = 0;

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && visited[i][j] == false) {

                    ArrayList<Integer> bag = new ArrayList<>();
                    collectGold(arr, i, j, visited, bag);

                    int sum = 0;
                    for (int val : bag)
                        sum += val;

                    if (max < sum)
                        max = sum;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] arr = { { 10, 0, 100, 200, 0, 8, 0 }, { 20, 0, 0, 0, 0, 6, 0 }, { 6, 0, 0, 9, 12, 3, 4 },
                { 40, 0, 2, 5, 8, 3, 11 }, { 0, 0, 0, 0, 0, 9, 0 }, { 5, 6, 7, 0, 7, 4, 2 },
                { 8, 9, 10, 0, 1, 10, 8 } };

        System.out.println(goldMine(arr));

    }
}
