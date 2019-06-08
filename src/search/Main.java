package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] res = new int[t];

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            int[] nums = new int[n];
            nums[0] = a;
            nums[1] = b;
            nums[2] = c;
            res[i] = solution(nums, n);
        }

        for (int i = 0 ; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

    private static int solution(int[] nums, int n) {
        for (int i = 3; i < n; i++) {
            int sum = nums[i - 3] + nums[i - 2] + nums[i - 1];
            if(sum / 10 != 0) {
                nums[i] = sum / 10;
                if(i < n - 1) {
                    i++;
                    nums[i] = sum % 10;
                }

            }else {
                nums[i] = sum;
            }

        }
        return nums[n - 1];
    }
}
