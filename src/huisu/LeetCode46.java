package huisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode46 {
    private List<List<Integer>> res;
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> list = new LinkedList<>();
        permute(nums, 0, list);
        return res;
    }

    private void permute(int[] nums, int index, LinkedList<Integer> list) {
        if(index == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                list.push(nums[i]);
                used[i] = true;
                permute(nums, index + 1, list);
                list.pop();
                used[i] = false;
            }
        }
    }
}
