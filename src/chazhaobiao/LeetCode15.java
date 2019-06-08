package chazhaobiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int k = 0; k < n; k++) {
            if(nums[k] > 0)
                break;

            if(k > 0 && nums[k] == nums[k - 1])
                continue;

            int target = -nums[k];
            int i = k + 1, j = n - 1;
            while (i < j) {
                if(nums[i] + nums[j] == target) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                    while(i < j && nums[i] == nums[i - 1]) i++;
                    while(i < j && nums[j] == nums[j + 1]) j--;
                } else if(nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return res;
    }
}
