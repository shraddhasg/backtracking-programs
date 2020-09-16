import java.util.ArrayList;

public class PartitionInKSubsets {

    public static void partitionInKSubsets(int i, int n, int k, int ansSofar, ArrayList<ArrayList<Integer>> ans) {

        int counter = 0;

        if (i > n) {
            if (ansSofar == k) {
                counter++;
                System.out.print(counter + " , ");

                for (ArrayList<Integer> set : ans) {
                    System.out.print(set + "  ");
                }
                System.out.println();
            }
            return;
        }

        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() > 0) {
                ans.get(j).add(i);

                partitionInKSubsets(i + 1, n, k, ansSofar, ans);

                ans.get(j).remove(ans.get(i).size() - 1);
            } else {
                ans.get(j).add(i);

                partitionInKSubsets(i + 1, n, k, ansSofar + 1, ans);

                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int ansSofar = 0;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++)
            ans.add(new ArrayList<>());

        partitionInKSubsets(1, n, k, ansSofar, ans);
    }
}
