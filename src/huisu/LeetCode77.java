package huisu;

import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    private  List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n <= 0 || k <= 0 || n < k)
            return res;
        List<Integer> list = new ArrayList<>();
        generateCombinations(n, k , 1, list);
        return res;
    }

    private void generateCombinations(int n, int k, int index, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            generateCombinations(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
