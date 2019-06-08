package sword;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution7 {
    public void getLeastNumbers(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if (k > length || k <= 0)
            return;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < length; i++) {
            if (i < k) {
                maxHeap.offer(input[i]);
            } else if (input[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }

        }

        for (Integer integer : maxHeap) {
            result.add(integer);
        }
    }
}
