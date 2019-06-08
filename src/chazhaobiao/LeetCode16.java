package chazhaobiao;

import java.util.Arrays;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                int newDiff = Math.abs(sum - target);
                if(newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }

                if(sum < target)
                    l++;
                else r--;
            }
        }

        return closest;
    }
}
