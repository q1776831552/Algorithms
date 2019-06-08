package zhenti;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] fight = new int[n];
        int[] money = new int[n];
        for(int i = 0; i < n; i++) {
            fight[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            money[i] = in.nextInt();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int cur = fight[0];
        int cost = 0;
        queue.offer(fight[0]);

        for(int i = 1; i < n; i++) {
            boolean flag = true;
            while(cur < fight[i]) {
                if(queue.peek() != null) {
                    int temp = queue.peek();
                    cost += find(n, fight, temp, money);
                    queue.poll();
                } else {
                    queue.offer(fight[i]);
                    flag = false;
                }
            }
            if(flag) {
                queue.offer(fight[i]);
            }
        }
        System.out.println(cost);
    }

    public static int find(int n, int[] fight, int temp, int[] money) {
        for (int j = 0; j < n; j++) {
            if(temp == fight[j]) {
                return  money[j];
            }
        }
        return 0;
    }
}
