package LeetcodeBootcamp.lecture6;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (minHeap.size() == k) {
                if (minHeap.peek()[1] < count) {
                    minHeap.poll();
                    minHeap.offer(new int[]{num, count});
                }
            } else {
                minHeap.offer(new int[]{num, count});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = minHeap.poll()[0];
        }
        return result;
    }
}
