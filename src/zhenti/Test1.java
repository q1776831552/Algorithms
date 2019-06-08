package zhenti;

import java.util.Arrays;

class Test1 {
    static int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int ret = tryRob(0, nums);
        return ret;
    }

    private static int tryRob(int index, int[] nums) {
        int res = 0;
        if(memo[index] != -1)
            return memo[index];

        for(int i = index; i < nums.length;i++) {
            res = Math.max(res, nums[i] + tryRob(i + 2, nums));
        }
        memo[index] = res;
        return res;
    }
}