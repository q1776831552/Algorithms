package stackAndQueue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int n = wordList.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(beginWord.equals(wordList.get(i)))
                visited[i] = true;
        }

        while (!queue.isEmpty()) {
            int length = queue.size();
            res++;
            for (int i = 0; i < length; i++) {
                String cur = queue.poll();
                if(cur.equals(endWord))
                    return res;
                for (int j = 0; j < n; j++) {
                    if(!visited[j] && isValid(cur, wordList.get(j))) {
                        visited[j] = true;
                        queue.offer(wordList.get(j));
                    }
                }
            }
        }

        return 0;
    }

    private boolean isValid(String s1, String s2) {
        int num = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i))
                num++;
        }

        return num == 1;
    }
}
