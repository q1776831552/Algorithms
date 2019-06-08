package huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode47 {
    private static List<List<Integer>> res;
    private static boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        permute(nums, 0, list);
        return res;
    }

    private static void permute(int[] nums, int index, LinkedList<Integer> list) {
        if(index == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.push(nums[i]);
            used[i] = true;
            permute(nums, index + 1, list);
            list.pop();
            used[i] = false;
    }
}
}
